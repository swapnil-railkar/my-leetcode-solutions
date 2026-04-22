package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P2452 {
	public List<String> solution(String[] queries, String[] dictionary) {
        List<String> answer = new ArrayList<>();
        for(String query : queries) {
            for(String word : dictionary) {
                if(canMadeEqual(query, word)) {
                    answer.add(query);
                    break;
                }
            }
        }
        return answer;
    }

    private boolean canMadeEqual(String word1, String word2) {
        int count = 0;
        if(word1.length() != word2.length()) {
            return false;
        }
        for(int i = 0; i< word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)) {
                count++;
                if(count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
