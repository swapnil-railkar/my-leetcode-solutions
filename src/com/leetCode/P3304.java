package com.leetCode;

public class P3304 {
	public char solution(int k) {
        String word = "a";
        while(word.length() < k) {
            word = getNextStr(word);
        }
        return word.charAt(k - 1);
    }

    private String getNextStr(String curr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< curr.length(); i++) {
            if(curr.charAt(i) == 'z') {
                sb.append('a');
            } else {
                char next = (char) (curr.charAt(i) + 1);
                sb.append(next);
            }
        }
        sb.insert(0, curr);
        return sb.toString();
    }
}
