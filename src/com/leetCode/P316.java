package com.leetCode;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

public class P316 {

	public String solution(String str) {
		Set<Character> uniqueChars = new TreeSet<>();
		for(int i=0; i< str.length(); i++) {
			uniqueChars.add(str.charAt(i));
		}
		List<Character> answer = getSetStartingWithMinChar(uniqueChars, str);
		return convertToString(answer);
	}
	
private List<Character> getSetStartingWithMinChar(Set<Character> uniqueChars, String str) {
		
		for(char ch : uniqueChars) {
			List<Character> list = new ArrayList<>();
			list.add(ch);
			int firstIndex = str.indexOf(ch);
			for(int i = firstIndex + 1; i< str.length(); i++) {
				int index = list.indexOf(str.charAt(i));
				if(index != -1) {
					if(str.charAt(i) == ch) {
						continue;
					}
					for(int j = index + 1; j< list.size(); j++) {
                        if(list.get(j) > str.charAt(i)) {
                        	// if we find out that list.get(j) will be removed in future 
                        	// and after index j in list there exists character which is less than str.charAt(i)
                        	// then we should remove str.charAt(i) from current index and it at end of current list state
                        	
                            break;
                        } else if (list.get(j) < str.charAt(i)) {
							list.remove(index);
							list.add(str.charAt(i));
							break;
						}
					}
				} else {
					list.add(str.charAt(i));
				}
			
			}
			if(list.size()== uniqueChars.size()) {
				return list;
			}
		}
		return new ArrayList<>(uniqueChars);
	}
	
	private String convertToString(List<Character> charList) {
		StringBuffer answer = new StringBuffer();
		for(char ch : charList) {
			answer.append(ch);
		}
		return answer.toString();
	}
}
