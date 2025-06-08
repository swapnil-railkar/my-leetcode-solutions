package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P438 {
	public List<Integer> findAnagrams(String s, String target) {
        if(target.length() > s.length()) {
            return Collections.emptyList();
        }
        int[] count = new int[26];
        List<Integer> startIndex = new ArrayList<>();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            count[c - 'a']++;
        }
        int[] window = new int[26];
        for (int i = 0; i < target.length(); i++) {
            char c = s.charAt(i);
            window[c - 'a']++;
        }
        if (Arrays.equals(count, window)) {
            startIndex.add(0);
        }
        for (int i = target.length(); i < s.length(); i++) {
            char c = s.charAt(i);
            window[c - 'a']++;
            window[s.charAt(i - target.length()) - 'a']--;
            if (Arrays.equals(count, window)) {
                startIndex.add(i - target.length() + 1);
            }
        }
        return startIndex;
    }
}
