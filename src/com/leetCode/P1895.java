package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P1895 {
	public int largestMagicSquare(int[][] grid) {
        int maxLength = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int length = getMSLength(grid, row, col);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    private int getMSLength(int[][] grid, int row, int col) {
        int length = 1;
        int maxLength = 1;
        int rows = grid.length;
        int cols = grid[0].length;
        while (row + length < rows && col + length < cols) {
            Set<Long> rowSet = new HashSet<>();
            //validate row sums.
            for (int i = row; i <= row + length; i++) {
                long rowSum = 0L;
                for (int j = col; j <= col + length; j++) {
                    rowSum += grid[i][j];
                }
                rowSet.add(rowSum);
            }

            //validate col sums.
            Set<Long> colSet = new HashSet<>();
            for (int i = col; i <= col + length; i++) {
                long colSum = 0L;
                for (int j = row; j <= row + length; j++) {
                    colSum += grid[j][i];
                }
                colSet.add(colSum);
            }

            //forward diag sum.
            long forDiagSum = 0L;
            for (int i = row, j = col; i <= row + length && j <= col + length; i++, j++) {
                forDiagSum += grid[i][j];
            }

            //backward diag sum.
            long backDiagSum = 0L;
            for (int i = row, j = col + length; i <= row + length; i++, j--) {
                backDiagSum += grid[i][j];
            }

            Set<Long> sumSet = new HashSet<>(rowSet);
            sumSet.addAll(colSet);
            sumSet.add(forDiagSum);
            sumSet.add(backDiagSum);
            if (sumSet.size() == 1) {
                maxLength = Math.max(maxLength, length + 1);
            }

            length++;
        }
        return maxLength;
    }
}
