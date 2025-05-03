package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1007 {

	public int solution(int[] tops, int[] bottoms) {
		Map<Integer, Integer> numFreqMap = new HashMap<>();
        Map<Integer, Integer> topFreqMap = new HashMap<>();
        Map<Integer, Integer> bottomFreqMap = new HashMap<>();

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == bottoms[i]) {
                int count = numFreqMap.getOrDefault(tops[i], 0) + 1;
                numFreqMap.put(tops[i], count);
            } else {
                int topCount = numFreqMap.getOrDefault(tops[i], 0) + 1;
                numFreqMap.put(tops[i], topCount);
                int bottomCount = numFreqMap.getOrDefault(bottoms[i], 0) + 1;
                numFreqMap.put(bottoms[i], bottomCount);
            }
            int topCount = topFreqMap.getOrDefault(tops[i], 0) + 1;
            topFreqMap.put(tops[i], topCount);
            int bottomCount = bottomFreqMap.getOrDefault(bottoms[i], 0) + 1;
            bottomFreqMap.put(bottoms[i], bottomCount);
        }

        int total = tops.length;
        Set<Integer> candidates = new HashSet<>();
        for(int key : numFreqMap.keySet()) {
            if(numFreqMap.get(key) >= total) {
                candidates.add(key);
            }
        }

        if(candidates.isEmpty()) {
            return -1;
        } else {
            int minCount = Integer.MAX_VALUE;
            for(int candidate : candidates) {
                int swapsReq = total - Math.max(topFreqMap.get(candidate), bottomFreqMap.get(candidate));
                minCount = Math.min(minCount, swapsReq);
            }
            return minCount;
        }
    }
}
