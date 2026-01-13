package com.leetCode;

import java.util.Arrays;

public class P3453 {
	public double solution(int[][] squares) {
        Arrays.sort(squares, (a, b) -> Integer.compare(a[1], b[1]));
        double totalArea = 0.0;
        for (int[] square : squares) {
            double side = square[2];
            totalArea += side * side;
        }

        double bottom = Double.MAX_VALUE;
        double top = Double.MIN_VALUE;

        for (int[] sq : squares) {
            bottom = Math.min(bottom, sq[1]);
            top = Math.max(top, sq[1] + sq[2]);
        }

        double EPS = 1e-5;
        double expectedArea = totalArea / 2;
        while (top - bottom > EPS) {
            double mid = (top + bottom) / 2;
            double areaTillMid = getAreaTillPoint(squares, mid);
            if (areaTillMid >= expectedArea) {
                top = mid;
            } else {
                bottom = mid;
            }
        }
        return top;
    }

    private double getAreaTillPoint(int[][] squares, double point) {
        double area = 0.0;

        for (int[] sq : squares) {
            if (sq[1] < point) {
                double y1 = Math.min(sq[1] + sq[2], point);
                area += (y1 - sq[1]) * sq[2];
            }
        }

        return area;
    }
}
