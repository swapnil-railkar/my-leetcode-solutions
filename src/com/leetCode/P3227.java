package com.leetCode;

import java.util.Set;

public class P3227 {
	public boolean doesAliceWin(String str) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        for(int i =0; i< str.length(); i++) {
            char curr = str.charAt(i);
            if(vowels.contains(curr)) {
                return true;
            }
        }
        return false;
    }
}
