package com.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P3531 {
	public int solution(int n, int[][] buildings) {
        Map<Integer, int[]> hFirst = new HashMap<>();
        Map<Integer, int[]> hLast = new HashMap<>();
        Map<Integer, int[]> vFirst = new HashMap<>();
        Map<Integer, int[]> vLast = new HashMap<>();

        for(int[] building : buildings) {
            int y = building[1];
            if(hFirst.containsKey(y)) {
                int[] currFirst = hFirst.get(y);
                if(building[0] < currFirst[0]) {
                	hFirst.put(y, building);
                }
            } else {
            	hFirst.put(y, building);
            }
            
            if(hLast.containsKey(y)) {
                int[] currFirst = hLast.get(y);
                if(building[0] > currFirst[0]) {
                	hLast.put(y, building);
                }
            } else {
            	hLast.put(y, building);
            }

            int x = building[0];
            if(vFirst.containsKey(x)) {
            	int[] currFirst = vFirst.get(x);
            	if(building[1] < currFirst[1]) {
            		vFirst.put(x, building);
            	}
            } else {
            	vFirst.put(x, building);
            }
            
            if(vLast.containsKey(x)) {
            	int[] currFirst = vLast.get(x);
            	if(building[1] > currFirst[1]) {
            		vLast.put(x, building);
            	}
            } else {
            	vLast.put(x, building);
            }
        }

        int count = 0;
        for(int[] building : buildings) {
            boolean isFirstVeritcally = Arrays.equals(building, vFirst.get(building[0]));
            boolean isLastVertically = Arrays.equals(building, vLast.get(building[0]));

            boolean isFirstHorizontally = Arrays.equals(building, hFirst.get(building[1]));
            boolean isLastHorizontally = Arrays.equals(building, hLast.get(building[1]));

            if(!isFirstVeritcally && !isLastVertically && !isFirstHorizontally && !isLastHorizontally) {
                count++;
            }
        }
        return count;
    }
}
