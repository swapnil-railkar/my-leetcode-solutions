package com.leetCode;

public class P11 {

	public int solution(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int max = Integer.MIN_VALUE;
        while(left < right) {
            max = Math.max(max, Math.min(nums[left], nums[right]) * (right - left));
            if(nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
