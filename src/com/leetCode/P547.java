package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P547 {
	public int solution(int[][] isConnected) {
		Map<Integer, Set<Integer>> repSetMap = new HashMap<>();
        int n = isConnected.length;
        for(int i = 0; i< n; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i);
            repSetMap.put(i, set);
        }
        for(int i = 0; i< n; i++) {
            for(int j = i; j< n; j++) {
                if(isConnected[i][j] == 1) {
                    int jKey = findRep(repSetMap, j);
                    int iKey = findRep(repSetMap, i);
                    if(jKey != iKey) {
                        Set<Integer> jSet = repSetMap.get(jKey);
                        repSetMap.get(iKey).addAll(jSet);
                        repSetMap.remove(jKey);
                    }
                }
            }
        }
        return repSetMap.size();
    }

    private int findRep(Map<Integer, Set<Integer>> repSetMap, int target) {
        if(repSetMap.containsKey(target)) {
            return target;
        }
        for(int key : repSetMap.keySet()) {
            if(repSetMap.get(key).contains(target)) {
                return key;
            }
        }
        return -1;
    }
}
