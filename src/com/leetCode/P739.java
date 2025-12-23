package com.leetCode;

import java.util.Stack;

public class P739 {
	public int[] solution(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[temperatures.length];
        for(int i = 0; i< temperatures.length; i++) {
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int index = stk.pop();
                ans[index] = i - index;
            }
            stk.push(i);
        }
        return ans;
    }
}
