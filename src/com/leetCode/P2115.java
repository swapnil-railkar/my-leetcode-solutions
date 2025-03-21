package com.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P2115 {

	public List<String> solution(String[] recipes, List<List<String>> ingredients, String[] supplies) {
		List<String> cooked = new ArrayList<>();
		Set<String> available = new HashSet<>();
		boolean[] added = new boolean[recipes.length];
		boolean newAdded = true;
		
		for(String supply : supplies) {
			available.add(supply);
		}
		
		while(newAdded) {
			newAdded = false;
			for(int i = 0; i< recipes.length; i++) {
				if(!added[i]) {
					if(available.containsAll(ingredients.get(i))) {
						cooked.add(recipes[i]);
						available.add(recipes[i]);
						newAdded = true;
						added[i] = true;
					}
				}
			}
		}
		
		return cooked;
	}
}
