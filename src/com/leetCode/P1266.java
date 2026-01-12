package com.leetCode;

public class P1266 {
	public int solution(int[][] points) {
		//Chebyshev Distance
        int[] prev = points[0];
        int dist = 0;
        for(int i = 1; i< points.length; i++) {
            int[] curr = points[i];
            int x1 = prev[0];
            int y1 = prev[1];
            int x2 = curr[0];
            int y2 = curr[1];
            dist += Math.max(Math.abs(x1-x2), Math.abs(y1-y2));
            prev = curr;
        }
        return dist;
    }
}
