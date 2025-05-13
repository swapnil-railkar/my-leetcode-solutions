package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P56 {
	
	public int[][] solution(int[][] intervals) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for(int[] interval : intervals) {
            pq.add(interval);
        }
        int[] currInterval = pq.remove();
        List<int[]> merged = new ArrayList<>();
        while(!pq.isEmpty()) {
            int[] nextInterval = pq.remove();
            if(currInterval[1] < nextInterval[0]) {
                merged.add(currInterval);
            } else {
                nextInterval[0] = Math.min(currInterval[0], nextInterval[0]);
                nextInterval[1] = Math.max(currInterval[1], nextInterval[1]);
            }
            currInterval = nextInterval;
        }
        merged.add(currInterval);
        int[][] ans = new int[merged.size()][2];
        for(int i =0; i< merged.size(); i++) {
            ans[i][0] = merged.get(i)[0];
            ans[i][1] = merged.get(i)[1];
        }
        return ans;
	}
}
