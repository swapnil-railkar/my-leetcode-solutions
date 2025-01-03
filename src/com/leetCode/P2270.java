package com.leetCode;

public class P2270 {

	public int solution(int[] nums) {
		long sum = 0;
		long leftSum = 0;
		long rightSum = 0;
		int validSplits = 0;
		
		for(int i=0; i< nums.length; i++) {
			sum += nums[i];
		}
		
		for(int i=0; i< nums.length - 1; i++) {
			leftSum += nums[i];
			rightSum = sum - leftSum;
			if(leftSum >= rightSum) {
				validSplits++;
			}
		}
		return validSplits;
	}
}
