package com.leetCode;

import java.util.Stack;

public class P66 {

	public int[] solution(int[] digits) {
		Stack<Integer> ans = new Stack<>();
        int sum = digits[digits.length - 1] + 1;
        ans.add(sum % 10);
        int carry = sum / 10;
        for (int i = digits.length - 2; i >= 0; i--) {
            sum = digits[i] + carry;
            ans.push(sum % 10);
            carry = sum / 10;
        }
        if(carry != 0) {
            ans.add(carry);
        }
        int[] nums = new int[ans.size()];
        for(int i = 0; i< nums.length; i++) {
            nums[i] = ans.pop();
        }
        return nums;
    }

}
