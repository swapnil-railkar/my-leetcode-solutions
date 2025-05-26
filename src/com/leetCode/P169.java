package com.leetCode;

import java.util.Arrays;

public class P169 {
	public int solution(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
