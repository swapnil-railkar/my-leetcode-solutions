package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P76 {
	public String solution(String str, String target) {
        if (target.length() > str.length()) {
            return "";
        }
        Map<Character, Integer> targetCount = new HashMap<>();
        for (int i = 0; i < target.length(); i++) {
            int count = targetCount.getOrDefault(target.charAt(i), 0) + 1;
            targetCount.put(target.charAt(i), count);
        }

        int left = 0, resLeft = 0;
        int minDist = Integer.MAX_VALUE;
        Map<Character, Integer> windowCount = new HashMap<>();
        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            if (targetCount.containsKey(c)) {
                windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
                if (valid(targetCount, windowCount)) {
                    // shrink from left until this is true.
                    while (valid(targetCount, windowCount)) {
                        char leftChar = str.charAt(left);
                        if (targetCount.containsKey(leftChar)) {
                            int value =  windowCount.get(leftChar) - 1 < 0 ? 0 : windowCount.get(leftChar) - 1;
                            windowCount.put(leftChar, value);
                        }
                        left++;
                    }
                    left--;
                    char leftChar = str.charAt(left);
                    windowCount.put(leftChar, windowCount.get(leftChar) + 1);
                    if (right - left + 1 < minDist) {
                        minDist = right - left + 1;
                        resLeft = left;
                    }
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? "" : buildString(resLeft, resLeft + minDist, str);
    }

    private boolean valid(Map<Character, Integer> target, Map<Character, Integer> window) {
        for(char key : target.keySet()) {
            if(target.get(key) > window.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }

    private String buildString(int left, int right, String str) {
        StringBuilder ans = new StringBuilder();
        for (int i = left; i < right; i++) {
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}
