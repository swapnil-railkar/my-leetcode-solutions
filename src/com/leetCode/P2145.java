package com.leetCode;

public class P2145 {
	
	public int solution(int[] differences, int lower, int upper) {
        int[] preSum = new int[differences.length];
        preSum[0] = differences[0];
        int min = preSum[0];
        int max = preSum[0];
        int count = 0;

        for(int i = 1; i< differences.length; i++) {
            int sum = preSum[i - 1] + differences[i];
            preSum[i] = sum;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        for(int i = lower; i<= upper; i++) {
            if((i + min) >= lower && (i + max) <= upper) {
                count++;
            }
        }

        return count;
    }

}
