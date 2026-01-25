package com.leetCode;

import java.util.Arrays;

public class P1877 {
	public int solution(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;

        for(int i = 0, j = nums.length - 1; i < j; i++, j--) {
            max = Math.max(max, nums[i] + nums[j]);
        }

        return max;
    }
}
