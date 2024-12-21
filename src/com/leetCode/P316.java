package com.leetCode;

import java.util.List;
import java.util.ArrayList;

public class P316 {

	public String solution(String str) {
		List<Character> charList = new ArrayList<>();
		for(int i=0; i< str.length(); i++) {
			addCharToList(charList, str.charAt(i));
		}
		return convertToString(charList);
	}
	
	public void addCharToList(List<Character> charList, char currChar) {
		int index = charList.indexOf(currChar);
		if(index != -1) {
			if(index + 1 < charList.size() && charList.get(index + 1) < currChar) {
				charList.remove(index);
				charList.add(currChar);
			}
		} else {
			charList.add(currChar);
		}
		
	}
	
	private String convertToString(List<Character> charList) {
		StringBuffer answer = new StringBuffer();
		for(char ch : charList) {
			answer.append(ch);
		}
		return answer.toString();
	}
}
