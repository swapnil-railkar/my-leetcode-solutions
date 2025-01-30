package com.leetCode;

import java.util.PriorityQueue;

// Explanation : https://youtu.be/oT7s3PjShNY?si=5QMghjEPvNqMVM8v
public class P1642 {

    public int solution(int[] heights, int bricks, int ladders) {
        return maxPosition(heights, bricks, ladders);
    }

    private int maxPosition(int[] heights, int bricks, int ladders) {
        int bricksUsed = 0;
        int increasingPaths = 0;
        PriorityQueue<Integer> usedBricks = new PriorityQueue<>();
        for (int i = 1; i< heights.length; i++) {
            int leap = heights[i] - heights[i-1];
            if (leap >= 0) {
                increasingPaths++;
                bricksUsed += leap;
                usedBricks.offer(leap * -1);
                if (bricksUsed > bricks) {
                    Integer maxDistance = usedBricks.poll();
                    bricksUsed += maxDistance;
                }

                if (usedBricks.size() + ladders < increasingPaths) {
                    return i - 1;
                }
            }
        }

        return heights.length - 1;
    }
}
