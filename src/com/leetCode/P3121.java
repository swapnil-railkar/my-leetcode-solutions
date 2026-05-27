package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P3121 {
	public int solution(String word) {
        Set<Character> lcase = new HashSet<>();
        Set<Character> special = new HashSet<>();
        Set<Character> removed = new HashSet<>();
        for(int i = 0; i< word.length(); i++) {
            char curr = word.charAt(i);
            if(removed.contains(Character.toLowerCase(curr))) {
                continue;
            }
            if(Character.isLowerCase(curr)) {
                lcase.add(curr);
                if(special.contains(curr)) {
                    special.remove(curr);
                    removed.add(curr);
                }
            }
            if(Character.isUpperCase(curr)) {
                char lower = Character.toLowerCase(curr);
                if(lcase.contains(lower)) {
                    special.add(lower);
                } else {
                    removed.add(lower);
                }
            }
        }
        return special.size(); 
    }
}
