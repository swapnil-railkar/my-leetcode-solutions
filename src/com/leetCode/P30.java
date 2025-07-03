package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P30 {
	public List<Integer> solution(String s, String[] words) {
		List<Integer> ans = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return ans;

        int wordLen = words[0].length();
        int totalWords = words.length;
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) { // Offset loop for word alignment
            int left = i, right = i;
            Map<String, Integer> seen = new HashMap<>();
            int count = 0;

            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCountMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordCountMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == totalWords) {
                        ans.add(left);
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return ans;
    }
}
