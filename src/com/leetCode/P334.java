package com.leetCode;

public class P334 {

	public boolean solution(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        int[] max = new int[nums.length];
        max[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i< nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for(int i = nums.length - 2; i>=0; i--) {
            max[i] = Math.max(max[i + 1], nums[i]);
        }
        for(int i = 0; i< nums.length; i++) {
            if(min[i] < nums[i] && nums[i] < max[i]) {
                return true;
            }
        }
        return false;
    }
}
