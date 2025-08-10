package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P869 {
	public boolean solution(int n) {
        String numStr = String.valueOf(n);
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i< 31; i++) {
            int pow = (int) Math.pow(2, i);
            String powStr = String.valueOf(pow);
            if (powStr.length() == numStr.length()) {
                Map<Character, Integer> powCountMap = new HashMap<>();
                for (int j = 0; j < powStr.length(); j++) {
                    char c = powStr.charAt(j);
                    powCountMap.put(c, powCountMap.getOrDefault(c, 0) + 1);
                }
                if(charCountMap.equals(powCountMap)) {
                    return true;
                }
            }
        }
        return false;
    }
}
