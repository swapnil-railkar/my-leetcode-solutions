package com.leetCode;

import java.util.Arrays;

public class P2966 {
	public int[][] solution(int[] nums, int k) {
		Arrays.sort(nums);
        int start = 0;
        int end = 2;
        int[][] ans = new int[nums.length / 3][3];
        int index = 0;
        while(end < nums.length) {
            if(nums[end] - nums[start] <= k) {
                ans[index][0] = nums[start];
                ans[index][1] = nums[start + 1];
                ans[index][2] = nums[end];
                index++;
            } else {
                return new int[][] {};
            }
            start += 3;
            end += 3; 
        }
        return ans;
    }
}
