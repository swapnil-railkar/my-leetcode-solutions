package com.leetCode;

import java.util.Set;

public class P3541 {
	public int solution(String str) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int[] freq = new int[26];
        int maxVfreq = 0;
        int maxCfreq = 0;
        for(int i = 0; i< str.length(); i++) {
            char curr = str.charAt(i);
            freq[curr - 'a']++;
            if(vowels.contains(curr)) {
                maxVfreq = Math.max(maxVfreq, freq[curr - 'a']);
            } else {
                maxCfreq = Math.max(maxCfreq, freq[curr - 'a']);
            }
        }
        return maxCfreq + maxVfreq;
    }
}
