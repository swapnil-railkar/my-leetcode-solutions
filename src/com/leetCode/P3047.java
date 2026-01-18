package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P3047 {
	public long solution(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        List<Wrapper> rectangles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rectangles.add(new Wrapper(bottomLeft[i], topRight[i]));
        }
        long maxArea = 0L;
        for (int i = 0; i < rectangles.size(); i++) {
            for (int j = 0; j < rectangles.size(); j++) {
                if (i != j) {
                    long overlappingArea = getOverlappingArea(rectangles.get(i), rectangles.get(j));
                    maxArea = Math.max(maxArea, overlappingArea);
                }
            }
        }
        return maxArea;
    }

    private long getOverlappingArea(Wrapper r1, Wrapper r2) {
        long width = Math.min(r1.endX, r2.endX) - Math.max(r1.startX, r2.startX);
        long height = Math.min(r1.endY, r2.endY) - Math.max(r1.startY, r2.startY);

        if (width > 0 && height > 0) {
            long side = Math.min(width, height);
            return side * side;
        }
        return 0L;
    }

    private class Wrapper {
        int startX;
        int endX;
        int startY;
        int endY;

        Wrapper(int[] bottomLeft, int[] topRight) {
            this.startX = bottomLeft[0];
            this.startY = bottomLeft[1];
            this.endX = topRight[0];
            this.endY = topRight[1];
        }
    }
}
