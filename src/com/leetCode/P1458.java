package com.leetCode;

import java.util.Arrays;

public class P1458 {
	public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        for(int i = nums1.length - 1; i>=0; i--) {
            for(int j = nums2.length - 1; j>=0; j--) {
                // consider both nums1[i] and nums2[j].
                int both = nums1[i] * nums2[j] + Math.max(0, dp[i + 1][j + 1]);
                // consider only nums1[i], skip nums2[j].
                int skip2 = dp[i][j + 1];
                // consider only nums2[i], skip nums1[j].
                int skip1 = dp[i + 1][j];
                dp[i][j] = Math.max(both, Math.max(skip1, skip2));
            }
        }
        return dp[0][0];
    }
}
