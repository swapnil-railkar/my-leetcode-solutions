package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1255 {
	public int maxScoreWords(String[] words, char[] letters, int[] scores) {
        Map<String, Integer> wordScoreMap = new HashMap<>();
        for(String word : words) {
            int score = 0;
            for(int i = 0;i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                score += scores[index];
            }
            wordScoreMap.put(word, score);
        }
        Map<Character, Integer> letterCountMap = new HashMap<>();
        for(char letter : letters) {
            letterCountMap.put(letter, letterCountMap.getOrDefault(letter, 0) + 1);
        }
        List<List<String>> result = new ArrayList<>();
        populateSubs(words, 0, new ArrayList<>(), result);
        int max = 0;
        for(List<String> subs : result) {
            int subSum = subsetCount(subs, letterCountMap, wordScoreMap);
            max = Math.max(max, subSum);
        }
        return max;
    }

    private void populateSubs(String[] words, int index, List<String> curr, List<List<String>> result) {
        if(index == words.length) {
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(words[index]);
        populateSubs(words, index + 1, curr, result);
        curr.remove(curr.size() - 1);
        populateSubs(words, index + 1, curr, result);
    }

    private int subsetCount(List<String> subs, Map<Character, Integer> charCountMap, Map<String, Integer> wordScoreMap) {
        int count = 0;
        Map<Character, Integer> subsCharCount = new HashMap<>();
        for(String word : subs) {
            for(int i = 0; i< word.length(); i++) {
                char c = word.charAt(i);
                subsCharCount.put(c, subsCharCount.getOrDefault(c, 0) + 1);
            }
        }
        for(char key : subsCharCount.keySet()) {
            int rem = charCountMap.getOrDefault(key, 0) - subsCharCount.get(key);
            if(rem < 0) {
                return 0;
            }
        }
        for(String word : subs) {
            count += wordScoreMap.get(word);
        }
        return count;
    }
}
