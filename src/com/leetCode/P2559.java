package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P2559 {
	
	public int[] solution(String[] words, int[][] queries) {
		int[] counts = new int[queries.length];
		int[] ranges = new int[words.length];
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		int range = 0;
		for(int i=0; i< ranges.length; i++) {
			String word = words[i];
			if(isValid(word, vowels)) {
				range++;
			}
			ranges[i] = range;
		}
		
		for(int i=0; i< queries.length; i++) {
			int startIndex = queries[i][0];
			int endIndex = queries[i][1];
			
			if(startIndex == 0) {
				counts[i] = ranges[endIndex];
			} else if(ranges[startIndex] == ranges[endIndex]){
				counts[i] = isValid(words[startIndex], vowels) ? 1 : 0;
			} else {
				counts[i] = ranges[endIndex] - ranges[startIndex - 1];
			}
		}
		return counts;
	}
	
	private boolean isValid(String word, Set<Character> vowels) {
		return vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1));
	}
}
