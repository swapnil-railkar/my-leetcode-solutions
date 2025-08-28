package com.leetCode;

public class P209 {
	public int solution(int target, int[] nums) {
        int left = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (left <= right && sum >= target) {
                sum -= nums[left];
                int size = right - left + 1;
                min = Math.min(min, size);
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
