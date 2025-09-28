package com.leetCode;

public class P812 {
	public double solution(int[][] points) {
        double max = 0.0;
        for(int i = 0; i< points.length; i++) {
            for(int j = i + 1; j< points.length; j++) {
                for(int k = j + 1; k< points.length; k++) {
                    double area = getArea(points[i], points[j], points[k]);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private double getArea(int[] p1, int[] p2, int[] p3) {
        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];
        int x3 = p3[0], y3 = p3[1];
        double val = (double) Math.abs((x1 * (y2 - y3)) + (x2 * (y3 - y1)) + (x3 * (y1 - y2)));
        return val / 2;
    } 
}
