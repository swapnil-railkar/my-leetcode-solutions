package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P409 {
	public int solution(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for(int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        int length = 0;
        for(char c : charCountMap.keySet()) {
            int count = charCountMap.get(c);
            int contri = 0;
            if(count % 2 == 0) {
                contri += count;
                charCountMap.put(c, 0);
            } else {
                contri += (count - 1);
                charCountMap.put(c, 1);
            }
            length += contri;
        }
        for(char c : charCountMap.keySet()) {
            if(charCountMap.get(c) == 1) {
                return length + 1;
            }
        }
        return length;
    }
}
