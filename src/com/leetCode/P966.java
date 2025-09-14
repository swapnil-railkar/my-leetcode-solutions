package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P966 {
	public String[] solution(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];
        Map<String, String> lowerCaseMap = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        Set<String> words = new HashSet<>();
        for(String word : wordlist) {
            words.add(word);
            // lower case map
            lowerCaseMap.putIfAbsent(word.toLowerCase(), word);

            // no vowel
            String noVowel = deVowel(word.toLowerCase());
            vowelMap.putIfAbsent(noVowel, word);
        }
        for(int i = 0; i< queries.length; i++) {
            String key = queries[i];
            if(words.contains(key)) {
                // exact match.
                ans[i] = key;
            } else if(lowerCaseMap.containsKey(key.toLowerCase())){
                ans[i] = lowerCaseMap.get(key.toLowerCase());
            } else {
                String noVowelKey = deVowel(key.toLowerCase());
                ans[i] = vowelMap.getOrDefault(noVowelKey, "");
            }
        }
        return ans;
    }

    private String deVowel(String word) {
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for(int i = 0; i< word.length(); i++) {
            if(vowels.contains(word.charAt(i))) {
                sb.append("*");
            } else {
                sb.append(word.charAt(i));
            }
        }
        return sb.toString();
    }
}
