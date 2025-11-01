package com.leetCode;

public class P2598 {
	public int solution(int[] nums, int value) {
        for(int i = 0; i< nums.length; i++) {
        	if(nums[i] > 0 && nums[i] < value) {
                continue;
            }
            nums[i] = Math.abs(nums[i]) % value;
        }
        boolean[] exists = new boolean[nums.length];
        for(int num : nums) {
            if(num < exists.length) {
                exists[num] = true;
            }
        }
        for(int i = 0; i< exists.length; i++) {
            if(!exists[i]) {
                return i;
            }
        }
        return exists.length;
    }
}
