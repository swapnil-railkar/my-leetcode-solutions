package com.leetCode;

public class P121 {
	public int solution(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }
        int left = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < left) {
                left = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - left);
            }
        }
        return maxProfit;
    }
}
