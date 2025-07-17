package com.leetCode;

public class P3202 {
	public int solution(int[] nums, int k) {
		int[][] dp = new int[nums.length][k];
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] + 1);
                max = Math.max(max, dp[i][mod]);
            }
        }
        return max + 1;
    }
}
