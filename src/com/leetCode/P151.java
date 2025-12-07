package com.leetCode;

public class P151 {
	public String solution(String s) {
        String[] words = s.trim().replaceAll("\\s+", ",").split(",");
        StringBuilder answerBuilder = new StringBuilder();
        for(int i = words.length - 1; i>=0; i--) {
            if(i == 0) {
                answerBuilder.append(words[i]);
            } else {
                answerBuilder.append(words[i] + " ");
            }
        }
        return answerBuilder.toString();
    }
}
