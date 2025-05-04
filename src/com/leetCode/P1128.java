package com.leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1128 {

	public int solution(int[][] dominoes) {
        Map<List<Integer>, Integer> pairCountMap = new HashMap<>();

        for(int[] domino: dominoes) {
        	List<Integer> list = List.of(domino[0], domino[1]);
        	List<Integer> rev = List.of(domino[1], domino[0]);
            if(pairCountMap.containsKey(list)) {
                int count = pairCountMap.get(list) + 1;
                pairCountMap.put(list, count);
            } else if(pairCountMap.containsKey(rev)) {
                int count = pairCountMap.get(rev) + 1;
                pairCountMap.put(rev, count);
            } else {
                pairCountMap.put(list, 1);
            }
        }

        int count = 0;
        for(List<Integer> key : pairCountMap.keySet()) {
            int pairCount = pairCountMap.get(key);
            count += (pairCount * (pairCount - 1)) / 2;
        }
        return count;
    }
}
