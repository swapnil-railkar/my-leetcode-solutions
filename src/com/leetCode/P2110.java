package com.leetCode;

public class P2110 {
	public long solution(int[] prices) {
        long count = 1;
        int left = 0;
        for(int right = 1; right< prices.length; right++) {
            if(prices[right - 1] != prices[right] + 1) {
                left = right;
            }
            count += (right - left) + 1;
        }
        return count;
    }
}
