package com.leetCode;

public class P316 {

	public String solution(String str) {
		// if letter is visited then true else false
		boolean[] visited = new boolean[26];
		StringBuilder answer = new StringBuilder();
		
		for(int i=0; i< str.length(); i++) {
			char currChar = str.charAt(i);
			int index = currChar - 'a';
			// if not visited then append to string
			if(!visited[index]) {
				answer.append(currChar);
				visited[index] = true;
				// fixup method to ensure answer is lexico-graphical
				fixup(str, visited, answer, i);
			}
		}
		
		return answer.toString();
 	}
	
	private void fixup(final String str, boolean[] visited, StringBuilder answer, final int index) {
		char recentEntry = answer.charAt(answer.length() - 1);
		
		for(int i = answer.length() - 1; i>= 0; i--) {
			// see if bigger character exists in string
			if(answer.charAt(i) > recentEntry) {
				// see if this bigger character occurs after index in string.
				boolean canAddLater = false;
				for(int j= index + 1; j< str.length(); j++) {
					if(str.charAt(j) == answer.charAt(i)) {
						canAddLater = true;
						break;
					}
				}
				if(canAddLater) {
					visited[answer.charAt(i) - 'a'] = false;
					answer.deleteCharAt(i);
				} else {
					// bigger character cannot be added later so answer before that cannot be modified.
					return;
				}
			}
		}
	}
}
