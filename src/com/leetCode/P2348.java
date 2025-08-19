package com.leetCode;

public class P2348 {
	public long solution(int[] nums) {
        long total = 0;
        long zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    total += ((zeroCount * (zeroCount + 1)) / 2);
                    zeroCount = 0;
                }
            }
        }
        total += ((zeroCount * (zeroCount + 1)) / 2);
        return total;
    }
}
