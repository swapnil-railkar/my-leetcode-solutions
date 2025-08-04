package com.leetCode;

public class P152 {
	public int solution(int[] nums) {
		int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        int minEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // When num is negative, swap max and min
            if (num < 0) {
                int temp = maxEndingHere;
                maxEndingHere = minEndingHere;
                minEndingHere = temp;
            }

            maxEndingHere = Math.max(num, maxEndingHere * num);
            minEndingHere = Math.min(num, minEndingHere * num);

            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
