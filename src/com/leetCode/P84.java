package com.leetCode;

import java.util.Stack;

public class P84 {
	public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stk.isEmpty() && heights[i] < heights[stk.peek()]) {
                int j = stk.pop();
                int height = heights[j];
                int leftWidth = stk.isEmpty() ? j : (j - 1) - stk.peek();
                int rightWidth = i - j;
                int width = leftWidth + rightWidth;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }
            stk.push(i);
        }

        int n = heights.length;
        while (!stk.isEmpty()) {
            int i = stk.pop();
            int height = heights[i];
            int leftWidth = stk.isEmpty() ? i : (i - 1) - stk.peek();
            int rightWidth = n - i;
            int width = leftWidth + rightWidth;
            int area = height * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
