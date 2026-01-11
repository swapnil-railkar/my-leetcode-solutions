package com.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P85 {
	public int solution(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (matrix[row][col] == '1') {
                    dp[row][col] = row - 1 >= 0 ? dp[row - 1][col] + 1 : 1;
                }
            }
        }

        int maxArea = 0;
        for (int row = 0; row < rows; row++) {
            Deque<Integer> stack = new ArrayDeque<>();
            for (int col = 0; col <= columns; col++) {
                int currHeight = (col == columns) ? 0 : dp[row][col];
                // pop while current bar is smaller
                while (!stack.isEmpty() && currHeight < dp[row][stack.peek()]) {
                    int height = dp[row][stack.pop()];
                    int right = col;
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int width = right - left - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(col);
            }

        }
        return maxArea;
    }
}
