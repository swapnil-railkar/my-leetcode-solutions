package com.leetCode;

public class P2926 {

	public long solution(int[] nums, int k) {
		int maxNum = Integer.MIN_VALUE;
        for(int num : nums) {
            maxNum = Math.max(num, maxNum);
        }

        int kCount = 0;
        int end = 0;
        long count = 0;
        for(int start = 0; start< nums.length; start++) {
            while(end < nums.length && kCount < k) {
            	if(nums[end] == maxNum) {
            		kCount++;
            	}
            	end++;
            }
            if(kCount >= k) {
            	count += (nums.length - end + 1);
            }
            if(nums[start] == maxNum) {
            	kCount--;
            }
        }
        return count;
    }
}
