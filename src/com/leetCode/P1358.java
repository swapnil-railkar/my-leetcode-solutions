package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P1358 {
	public int solution(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        int ans = 0;
        int left = 0;
        for(int right = 0; right< s.length(); right++) {
            int count = charCountMap.getOrDefault(s.charAt(right), 0) + 1;
            charCountMap.put(s.charAt(right), count);
            while(charCountMap.keySet().size() == 3) {
                ans += s.length() - right;
                int leftCount = charCountMap.get(s.charAt(left));
                if(leftCount == 1) {
                    charCountMap.remove(s.charAt(left));
                } else {
                    charCountMap.put(s.charAt(left), leftCount - 1);
                }
                left++;
            }
        }
        return ans;
    }
}
