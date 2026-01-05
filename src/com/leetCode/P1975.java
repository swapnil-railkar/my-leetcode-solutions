package com.leetCode;

public class P1975 {
	public long solution(int[][] matrix) {
		int negCount = 0;
        int n = matrix.length;
        long minPos = Integer.MAX_VALUE;
        long maxNeg = Integer.MIN_VALUE;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] < 0) {
                    negCount++;
                    maxNeg = Math.max(maxNeg, matrix[row][col]);
                }
                if (matrix[row][col] >= 0) {
                    minPos = Math.min(minPos, matrix[row][col]);
                }
            }
        }

        long sum = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                sum += Math.abs(matrix[row][col]);
            }
        }
        if (negCount % 2 != 0) {
            // negative numbers exists
            if(negCount == n*n) {
                // all numbers are negative
                sum += (maxNeg * 2);
            } else if(Math.abs(maxNeg) < minPos) {
                // absolute value of maximum negative is lesser than minimum positive.
                sum += (maxNeg * 2);
            } else {
                // absolute value of maximum negative is greater than minimum positive.
                sum += (minPos * -2);
            }
        }
        return sum;
    }
}
