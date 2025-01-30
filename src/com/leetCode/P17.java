package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P17 {

	public List<String> solution(String numbers) {
		List<String> combinations = new ArrayList<>();
		combinations = Collections.emptyList();
		
		for(int i=0; i< numbers.length(); i++) {
			char num = numbers.charAt(i);
			List<String> letters = cache(num);
			combinations = merge(combinations, letters);
		}
		return combinations;
	}
	
	private List<String> merge(List<String> combinations, List<String> letters) {
		if (combinations.isEmpty()) {
			return letters;
		}
		
		List<String> newCombinations = new ArrayList<>();
	
		for(String combination: combinations) {
			for(String letter: letters) {
				String newCombination = combination + letter;
				newCombinations.add(newCombination);
			}
		}
		
		return newCombinations;
	}
	
	private List<String> cache(char key) {
		
		switch(key) {
		case '2':
			return List.of("a","b","c");
		case '3':
			return List.of("d","e","f");
		case '4':
			return List.of("g","h","i");
		case '5':
			return List.of("j","k","l");
		case '6':
			return List.of("m","n","o");
		case '7':
			return List.of("p","q","r","s");
		case '8':
			return List.of("t","u","v");
		case '9':
			return List.of("w","x","y","z");
		default:
			return Collections.emptyList();
		}
		
	}
}
