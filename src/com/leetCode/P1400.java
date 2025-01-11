package com.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class P1400 {

	public boolean solution(String s, int k) {
		if(s.length() < k) {
            return false;
        }
        Map<Character, Integer> charCountMap = new HashMap<>();

        for(int i=0; i< s.length(); i++) {
            char c = s.charAt(i);
            if(!charCountMap.containsKey(c)) {
                charCountMap.put(c, 1);
            } else {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
        }

        return canConstruct(charCountMap, k);
	}
	
	private boolean canConstruct(Map<Character, Integer> charCountMap, int k) {
        Set<Character> keys = charCountMap.keySet();
        int oddCount = 0;
        for(char key : keys) {
            int count = charCountMap.get(key);
            if(count % 2 == 1) {
                oddCount++;
            }
            if(oddCount > k) {
                return false;
            }
        }
        return true;
    }
}
