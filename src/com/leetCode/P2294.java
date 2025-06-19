package com.leetCode;

import java.util.Arrays;

public class P2294 {
	public int solution(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] > k) {
                count++;
                left = right;
            }
            right++;
        }
        if (nums[nums.length - 1] - nums[left] <= k || nums[nums.length] <= k) {
            count++;
        }
        return count;
    }
}
