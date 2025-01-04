package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1930 {

	public int solution(String str) {
		int[] lastIndex = new int[26];
		Map<Character, Set<Character>> cache = new HashMap<>();

		// get last occurrence of each character in string
		for(int i = str.length() - 1; i>=0; i--) {
			int index = str.charAt(i) - 'a';
			if(lastIndex[index] == 0) {
				lastIndex[index] = i;
			}
		}

		// populate cache for each character in string
		for(int i=0; i< str.length(); i++) {
			updateCache(cache, i, str.charAt(i), lastIndex);
		}

		// get sum of all entries in cache
		return getCount(cache);
	}

	private void updateCache(Map<Character, Set<Character>> cache, int index, char currChar, int[] lastIndex) {
		Set<Character> keys = cache.keySet();

		for(char key : keys) {
			// check if current index is less than or equal to last index of key
			if(index < lastIndex[key - 'a']) {
				// add currChar to set.
				cache.get(key).add(currChar);
			}
		}
		
		if(!cache.containsKey(currChar)) {
			Set<Character> charSet = new HashSet<>();
			// check if current index is also last index for currChar
			int lastIndexOfCurrChar = lastIndex[currChar - 'a'];
			if(lastIndexOfCurrChar != index) {
				cache.put(currChar, charSet);;
			}

		} 

	}

	private int getCount(Map<Character, Set<Character>> cache) {
		int count = 0;
		Set<Character> keys = cache.keySet();

		for(char key : keys) {
			count += cache.get(key).size();
		}
		return count;
	}
}
