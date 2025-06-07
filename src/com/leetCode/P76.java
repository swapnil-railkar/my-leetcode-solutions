package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P76 {
	public String solution(String str, String target) {
        if(target.length() > str.length()) {
            return "";
        }
        Map<Character, Integer> targetCharCount = new HashMap<>();
        for(int i =0; i< target.length(); i++) {
            int count = targetCharCount.getOrDefault(target.charAt(i), 0) + 1;
            targetCharCount.put(target.charAt(i), count);
        }
        int req = targetCharCount.size(), have = 0;
        int left = 0, resLeft = 0;
        int minDist = Integer.MAX_VALUE;
        Map<Character, Integer> windowCountMap = new HashMap<>();
        for(int right = 0; right < str.length(); right++) {
        	char c = str.charAt(right);
        	windowCountMap.put(c, windowCountMap.getOrDefault(c, 0) + 1);
        	
        	if(targetCharCount.containsKey(c) && windowCountMap.get(c) == targetCharCount.get(c)) {
        		have++;
        	}
        	while(have == req) {
        		if(right - left + 1 < minDist) {
        			minDist = right - left + 1;
        			resLeft = left;
        		}
        		char leftChar = str.charAt(left);
        		windowCountMap.put(leftChar, windowCountMap.get(leftChar) - 1);
        		if(targetCharCount.containsKey(leftChar) && windowCountMap.get(leftChar) < targetCharCount.get(leftChar)) {
        			have--;
        		}
        		left++;
        	}
        }
        return minDist == Integer.MAX_VALUE ? "" : buildString(resLeft, resLeft + minDist, str);
    }

    private String buildString(int left, int right, String str) {
        StringBuilder ans = new StringBuilder();
        for(int i = left; i< right; i++) {
            ans.append(str.charAt(i));
        }
        return ans.toString();
    }
}
