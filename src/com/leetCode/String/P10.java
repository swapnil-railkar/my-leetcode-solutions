package com.leetCode.String;

public class P10 {

	// '.' Matches any single character.​​​​
	// '*' Matches zero or more of the preceding element.

	public boolean solution(String str, String pattern){
		try {
			int strPtr = 0;
			for(int i=0 ; i< pattern.length(); i++) {
				if (pattern.charAt(i) == str.charAt(strPtr)) {
					strPtr++;
				} else {
					if (pattern.charAt(i) == '.' ) {
						strPtr++;
					} else if (pattern.charAt(i) == '*') {
						while(strPtr < str.length() && 
								(pattern.charAt(i - 1) == str.charAt(strPtr) || pattern.charAt(i - 1) == '.') ) {
							strPtr++;
						}
					} else {
						if(pattern.charAt(i + 1) == '*') {
							i++;
						} else {
							return false;
						}
					}
				}
			}
			return strPtr == str.length() && lastCharacterMatches(str, pattern);
		} catch(Exception e) {
			return false;
		}
	}
	
	private boolean lastCharacterMatches(final String str, final String pattern) {
		int strLastIndex = str.length() - 1;
		int ptrLastIndex = pattern.length() - 1;
		
		if (pattern.charAt(ptrLastIndex) == '*' || pattern.charAt(ptrLastIndex) == '.') {
			return true;
		} else {
			return str.charAt(strLastIndex) == pattern.charAt(ptrLastIndex);
		}
	}

}
