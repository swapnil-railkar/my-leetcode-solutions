package com.leetCode;

public class P53 {

    public int solution(int[] nums) {
    	int[] maxSum = new int[nums.length];
        maxSum[0] = nums[0];
        for(int i = 1; i< nums.length; i++) {
            maxSum[i] = Math.max(maxSum[i - 1] + nums[i], nums[i]);
        }
        int sum = Integer.MIN_VALUE;
        for(int max : maxSum) {
            sum = Math.max(sum, max);
        }
        return sum;
    }
}
