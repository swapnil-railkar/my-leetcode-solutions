package com.leetCode;

public class P2017 {

	public long solution(int[][] grid) {
		int columns = grid[0].length;
		long[][] prefixSum = getPrefixSum(grid);
		long answer = Long.MAX_VALUE;
        long r0Rem = 0;
        long r1Rem = 0;
        long bot = 0;
		for(int column = 0; column < columns; column++) {
            r0Rem = prefixSum[0][columns - 1] - prefixSum[0][column];
            if(column > 0) {
               r1Rem = prefixSum[1][column - 1];
            }
            bot = Math.max(r0Rem, r1Rem);
            answer = Math.min(answer, bot);
        }
        return answer;
	}

	private long[][] getPrefixSum(int[][] grid) {
		int columns = grid[0].length;
		long[][] prefixSum = new long[2][columns];
		prefixSum[0][0] = grid[0][0];
		prefixSum[1][0] = grid[1][0];
		for(int i = 1; i < columns; i++) {
			prefixSum[0][i] = grid[0][i] + prefixSum[0][i - 1];
			prefixSum[1][i] = grid[1][i] + prefixSum[1][i - 1];
		}
		return prefixSum;
	}
}
