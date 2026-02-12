package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P3713 {
	public int solution(String s) {
        int maxLength = 1;
        for(int i = 0; i< s.length(); i++) {
            Map<Character, Integer> charCount = new HashMap<>();
            charCount.put(s.charAt(i), 1);
            for(int j = i + 1; j< s.length(); j++) {
                charCount.put(s.charAt(j), charCount.getOrDefault(s.charAt(j), 0) + 1);
                if(isBalanced(charCount)) {
                    int length = j - i + 1;
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }

    private boolean isBalanced(Map<Character, Integer> charCount) {
        int prev = -1;
        for(char key : charCount.keySet()) {
            int count = charCount.get(key);
            if(prev == -1) {
                prev = count;
            } else if(count != prev) {
                return false;
            }
        }
        return true;
    }
}
