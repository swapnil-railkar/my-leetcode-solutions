package com.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1408 {

	public List<String> solution(String[] words) {
		Set<String> subStrings = new HashSet<>();

        for(int i =0; i< words.length; i++) {
            String currStr = words[i];
            if(!subStrings.contains(currStr)) {
                for(int j = i + 1; j < words.length; j++) {
                    if(currStr.length() < words[j].length() && words[j].contains(currStr)) {
                        // current string is substring of jth string
                        subStrings.add(currStr);
                    } else if(currStr.contains(words[j])) {
                        // jth string is substring of current string
                        subStrings.add( words[j]);
                    }
                }
            }
        }
        return new ArrayList<>(subStrings);
	}
}
