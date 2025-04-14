package com.leetCode;

public class P2140 {

	public long solution(int[][] questions) {
		long[] maxSum = new long[questions.length];
		long max = 0;
		for(int i = questions.length - 1; i >=0; i--) {
			int points = questions[i][0];
			int brainPower = questions[i][1];
			int nextIndex = i + brainPower + 1;
			if(nextIndex > questions.length - 1) {
				if(i == questions.length - 1) {
					maxSum[i] = points;
				} else {
					maxSum[i] = Math.max(points, maxSum[i + 1]);
				}
			} else {
				maxSum[i] = Math.max(points + maxSum[nextIndex], maxSum[i + 1]);
			}
			max = Math.max(max, maxSum[i]);
		}
		
		return max;
	}

}
