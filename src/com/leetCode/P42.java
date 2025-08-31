package com.leetCode;

public class P42 {
	public int solution(int[] heights) {
        int n = heights.length;
        int[] maxL = new int[n];
        int[] maxR = new int[n];

        maxL[0] =  heights[0];
        int prev = maxL[0];
        for(int i = 1; i< n; i++) {
            maxL[i] = prev;
            prev = Math.max(prev, heights[i]);
        }

        maxR[n - 1] = heights[n - 1];
        prev = maxR[n - 1];
        for(int i = n - 2; i>= 0; i--) {
            maxR[i] = prev;
            prev = Math.max(prev, heights[i]);
        }

        int storage = 0;
        for(int i = 0; i< n; i++) {
            int val = Math.min(maxL[i], maxR[i]) - heights[i];
            if(val > 0) {
                storage += val;
            }
        }
        return storage;
    }
}
