package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class P2197 {
	public List<Integer> solution(int[] nums) {
        Stack<Integer> stk = new Stack<>();
        stk.add(nums[0]);
        for(int i = 1; i< nums.length; i++) {
            int num1 = stk.peek();
            int num2 = nums[i];
            if(gcd(num1, num2) > 1) {
                int num = lcm(num1, num2);
                stk.pop();
                while(!stk.isEmpty() && gcd(stk.peek(), num) > 1) {
                    num = lcm(stk.pop(), num);
                }
                stk.add(num);
            } else {
                stk.add(num2);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!stk.isEmpty()) {
            ans.add(stk.pop());
        }
        Collections.reverse(ans);
        return ans;
    }

    private int gcd(int num1, int num2) {
        if(num2 == 0) {
            return num1;
        }
        return gcd(num2, num1%num2);
    }

    private int lcm(int num1, int num2) {
        long mul = (long) num1 * num2;
        return (int) (mul/gcd(num1, num2));
    }
}
