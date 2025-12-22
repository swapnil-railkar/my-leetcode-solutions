package com.leetCode;

import java.util.Stack;

public class P1475 {
	public int[] finalPrices(int[] prices) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            while (!stk.isEmpty() && prices[i] <= prices[stk.peek()]) {
                int index = stk.pop();
                ans[index] = prices[index] - prices[i];
            }
            stk.push(i);
        }
        while(!stk.isEmpty()) {
            int index = stk.pop();
            ans[index] = prices[index];
        }
        return ans;
    }
}
