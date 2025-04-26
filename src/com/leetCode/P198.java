package com.leetCode;

public class P198 {
	
	public int solution(int[] nums) {
		if(nums.length == 1) {
            return nums[0];
        }
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		sum[1] = nums[1];
		for(int i = 2; i< nums.length; i++) {
			if((i - 3) >= 0) {
				sum[i] = nums[i] + Math.max(sum[i -2], sum[i -3]);
			} else {
				sum[i] = nums[i] + sum[i - 2];
			}
		}
		
		return Math.max(sum[sum.length - 1], sum[sum.length - 2]);
	}

}
