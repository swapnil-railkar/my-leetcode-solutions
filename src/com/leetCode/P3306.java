package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P3306 {

	public int solution(String str, int k) {
		int cons = 0;
		int subs = 0;

		for(int i=0; i< str.length(); i++) {
			Set<Character> vowels = new HashSet<>();
			cons = 0;
			for(int j = i; j < str.length(); j++) {
				if(isVowel(str.charAt(j))) {
					vowels.add(str.charAt(j));
				} else {
					cons++;
				}
				if(vowels.size() == 5 && cons == k) {
					subs++;
				} else if(cons > k) {
					break;
				}
			}
		}

		return subs;
	}

	private boolean isVowel(char c) {
		switch(c) {
		case 'a' :
		case 'e' :
		case 'i' :
		case 'o' :
		case 'u' :
			return true;
		default : return false;
		}
	}
}
