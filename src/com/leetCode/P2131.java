package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P2131 {
	public int solution(String[] words) {
		Map<String, Integer> cache = new HashMap<>();
        int length = 0;
        for(String word : words) {
            String rev = "" + word.charAt(1) + word.charAt(0);
            if (cache.containsKey(rev)) {
                length += 4;
                int freq = cache.get(rev) - 1;
                if(freq == 0) {
                	cache.remove(rev);
                } else {
                	cache.put(rev, freq);
                }
            } else {
            	int freq = cache.getOrDefault(word, 0) + 1;
                cache.put(word, freq);
            }
        }
        for(String word : cache.keySet()) {
            if(word.charAt(0) == word.charAt(1)) {
                return length + 2;
            }
        }
        return length;
    }
}
