package com.leetCode;

public class P312 {
	public int solution(int[] nums) {
        int[] ballons = new int[nums.length + 2];
        ballons[0] = 1;
        ballons[ballons.length - 1] = 1;
        for(int i = 0; i< nums.length; i++) {
            ballons[i + 1] = nums[i];
        }
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        return burst(dp, ballons, 0, ballons.length - 1);
    }

    private int burst(int[][] dp, int[] ballons, int left, int right) {
        if(left + 1 == right) {
            return 0;
        }
        if(dp[left][right] > 0) {
            return dp[left][right];
        }
        int max = 0;
        for(int i = left + 1; i< right; i++) {
            int coins = ballons[left] * ballons[i] * ballons[right];
            coins += burst(dp, ballons, left, i);
            coins += burst(dp, ballons, i, right);
            max = Math.max(max, coins);
        }
        dp[left][right] = max;
        return max;
    }
}
