package com.leetCode;

import java.util.PriorityQueue;

public class P973 {
	public int[][] solution(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(calculateDistance(a[0], a[1]), calculateDistance(b[0], b[1])));
        for(int[] point : points) {
            pq.add(point);
        }
        int[][] ans = new int[k][2];
        for(int i =0; i< k; i++) {
            int[] point = pq.remove();
            ans[i][0] = point[0];
            ans[i][1] = point[1];
        }
        return ans;
    }

    private double calculateDistance(int x, int y) {
        return Math.sqrt(x*x + y*y);
    }
}
