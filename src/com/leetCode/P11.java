package com.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class P11 {

    public int solution(int[] heights) {
        Map<Integer, Integer> indexes = new HashMap<>();
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int totDist = 0;
        for(int i=0; i< heights.length; i++) {
            if (heights[i] != 0) {
                if (!stack.isEmpty()) {
                    int startNum = getStartIndexFromStack(stack, heights[i]);
                    int startIndex = indexes.get(startNum);
                    int distancesForStartIndex = distanceMap.getOrDefault(startNum, 0);
                    int dist = (i - (startIndex + 1)) * Math.min(startNum, heights[i]);
                    // Find all distances for indexes greater than startIndex and diff them from totDist
                    // Treat blocks from startIndex to endIndex as obs and delete them from calculated dist.
                    totDist = distancesForStartIndex;
                    int blocks = 0;
                    for (int j = startIndex + 1; j < i ; j++) {
                        blocks += heights[j];
                    }
                    dist -= blocks;
                    totDist += dist;
                    while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                        stack.pop();
                    }
                }

                stack.push(heights[i]);
                indexes.put(heights[i], i);
                distanceMap.put(heights[i], totDist);
            }
        }
        return totDist;
    }

    private int getStartIndexFromStack(Stack<Integer> stack, int height) {
        // max in stack but less than height
        int min = 0;
        int max = Integer.MAX_VALUE;
        for (Integer num: stack) {
            if (num >= min && num <= height) {
                min = num;
            }
            if (num >= height && num < max) {
                max = num;
            }
        }

        return max == Integer.MAX_VALUE ? min : max;
    }
}
