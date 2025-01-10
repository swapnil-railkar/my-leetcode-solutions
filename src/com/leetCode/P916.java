package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P916 {
	
	public List<String> solution(String[] words1, String[] words2) {
		Map<Character, Integer> expectedCharCountMap = new HashMap<>();
	    List<String> universalStrings = new ArrayList<>();
	    
	    for(int i =  0; i< words2.length; i++) {
	    	Map<Character, Integer> map = new HashMap<>();
	    	String word = words2[i];
	    	for(int j = 0; j < word.length(); j++) {
	    		if(!map.containsKey(word.charAt(j))) {
	    			map.put(word.charAt(j), 1);
	    		} else {
	    			map.put(word.charAt(j), map.get(word.charAt(j)) + 1);
	    		}
	    	}
	    	expectedCharCountMap = combineMaps(expectedCharCountMap, map);
	    }

	    Map<Character, Integer> actualCharCountMap = null;	    
	    for(int i = 0; i< words1.length; i++) {
	    	actualCharCountMap = new HashMap<>();
	    	String word = words1[i];
	    	for(int j = 0; j < word.length(); j++) {
	    		if(!actualCharCountMap.containsKey(word.charAt(j))) {
	    			actualCharCountMap.put(word.charAt(j), 1);
	    		} else {
	    			actualCharCountMap.put(word.charAt(j), actualCharCountMap.get(word.charAt(j)) + 1);
	    		}
	    		
	    	}
	    	if(isUniversal(actualCharCountMap, expectedCharCountMap)) {
	    		universalStrings.add(word);
	    	}
	    }

	    return universalStrings;
	}
	
	private Map<Character, Integer> combineMaps(Map<Character, Integer> combinedMap, Map<Character, Integer> newMap) {
		Set<Character> keys = newMap.keySet();
		for(char key : keys) {
			if(!combinedMap.containsKey(key)) {
				combinedMap.put(key, newMap.get(key));
			} else {
				int oldValue = combinedMap.get(key);
				int newValue = newMap.get(key);
				if(newValue > oldValue) {
					combinedMap.put(key, newValue);
				}
			}
		}
		return combinedMap;
	}
	
	private boolean isUniversal(Map<Character, Integer> actualCharCountMap, Map<Character, Integer> expectedCharCountMap) {
		Set<Character> keys = expectedCharCountMap.keySet();
		for(char key : keys) {
			if(!actualCharCountMap.containsKey(key)) {
				return false;
			} else {
				int expectedCount = expectedCharCountMap.get(key);
				int actualCount = actualCharCountMap.get(key);
				if(expectedCount > actualCount) {
					return false;
				}
			}
		}
		return true;
	}
	
}
