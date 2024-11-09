package com.leetCode.String;

public class P10 {

	// '.' Matches any single character.​​​​
	// '*' Matches zero or more of the preceding element.

	public boolean solution(String str, String pattern){
		try {
			int stringPtr = 0;
			for (int i=0; i< pattern.length(); i++) {
				if (pattern.charAt(i) == str.charAt(stringPtr)) {
					stringPtr++;
				} else {
					if (pattern.charAt(i) == '.') {
						stringPtr++;
						continue;
					} else if (pattern.charAt(i) == '*') {

						char prevChar = pattern.charAt(i - 1);
						while(stringPtr < str.length() 
								&& (str.charAt(stringPtr) == prevChar || prevChar == '.')) {
							stringPtr++;
						}

					} else {
						//pattern.charAt(patternPtr) =/= str.charAt(i) 
						if (pattern.charAt(i + 1) == '*') {
							i++;
							continue;
						} else {
							return false;
						}

					}
				}
			}
			return true;
		}catch (Exception e) {
			return false;
		}

	}

}
