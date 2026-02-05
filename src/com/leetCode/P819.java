package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P819 {
	public String solution(String paragraph, String[] banned) {
		Map<String, Integer> wordCountMap = new HashMap<>();
        Set<String> bWords = new HashSet<>();
        for (String bWord : banned) {
            bWords.add(bWord);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paragraph.length(); i++) {
            char curr = paragraph.charAt(i);
            if (Character.isLetterOrDigit(curr)) {
                sb.append(curr);
            } else {
                String word = sb.toString().toLowerCase();
                sb = new StringBuilder();
                if (!word.isEmpty() && !bWords.contains(word)) {
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        }
        String word = sb.toString().toLowerCase();
        if (!word.isEmpty() && !bWords.contains(word)) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        String maxWord = "";
        int maxCount = Integer.MIN_VALUE;
        for (String key : wordCountMap.keySet()) {
            int count = wordCountMap.get(key);
            if (count > maxCount) {
                maxWord = key;
                maxCount = count;
            }
        }
        return maxWord;
    }
}
