package com.leetCode;

public class P3392 {

	public int solution(int[] nums) {
        int start = 0;
        int end = 2;
        int count = 0;
        while(end < nums.length) {
        	double sum = Double.valueOf(nums[start] + nums[end]);
        	double half = ((double) nums[end - 1]) / 2;
            if(sum == half) {
                count++;
            }
            start++;
            end++;
        }
        return count;
    }
}
