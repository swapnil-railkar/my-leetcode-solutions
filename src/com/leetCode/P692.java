package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P692 {
	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordFreqMap = new HashMap<>();
        for(String word : words) {
            wordFreqMap.put(word, wordFreqMap.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((a, b) -> {
            if(a.freq == b.freq) {
                return a.word.compareTo(b.word);
            }
            return Integer.compare(b.freq, a.freq);
        });
        for(String key: wordFreqMap.keySet()) {
            pq.add(new Wrapper(key, wordFreqMap.get(key)));
        }

        List<String> ans = new ArrayList<>();
        for(int i = 0; i< k; i++) {
            ans.add(pq.poll().word);
        }
        return ans;
    }

    private class Wrapper {
        String word;
        int freq;
        Wrapper(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
}
