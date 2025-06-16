package com.leetCode;

public class P2016 {
	public int solution(int[] nums) {
        int min = nums[0];
        int maxDiff = -1;
        for(int i = 1; i< nums.length; i++) {
            if(nums[i] < min) {
                min = nums[i];
            } else if(nums[i] > min) {
                maxDiff = Math.max(maxDiff, nums[i] - min);
            }
        }
        return maxDiff;
    }
}
