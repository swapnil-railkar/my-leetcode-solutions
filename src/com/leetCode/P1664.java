package com.leetCode;

public class P1664 {
	public int solution(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return 1;
        }
        int[] oddSum = new int[n];
        int[] evenSum = new int[n];
        evenSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (i % 2 == 0) {
                evenSum[i] = evenSum[i - 1] + nums[i];
                oddSum[i] = oddSum[i - 1];
            } else {
                oddSum[i] = oddSum[i - 1] + nums[i];
                evenSum[i] = evenSum[i - 1];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (Math.max(evenSum[n - 1], oddSum[n - 1]) - Math.min(evenSum[n - 1], oddSum[n - 1]) == nums[i]) {
                    count++;
                }
                continue;
            }
            int even = evenSum[i - 1] + (oddSum[n - 1] - oddSum[i]);
            int odd = oddSum[i - 1] + (evenSum[n - 1] - evenSum[i]);
            if (even == odd) {
                count++;
            }
        }
        return count;
    }
}
