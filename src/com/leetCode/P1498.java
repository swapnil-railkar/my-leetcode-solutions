package com.leetCode;

import java.util.Arrays;

public class P1498 {
	public int solution(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_007;
        int[] pow2 = new int[nums.length];
        pow2[0] = 1;
        for(int i = 1; i< pow2.length; i++) {
            pow2[i] = (pow2[i - 1] * 2) % mod;
        }
        int left = 0, right = nums.length - 1, count = 0;
        while(left <= right) {
            if(nums[left] + nums[right] <= target) {
                count = (count + pow2[right - left]) % mod;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
