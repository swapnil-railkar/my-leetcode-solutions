package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P840 {
	public int solution(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        if (rows < 3 || columns < 3) {
            return 0;
        }

        int[][] rowSum = new int[rows][columns - 2];
        int[][] colSum = new int[rows - 2][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns - 2; column++) {
                rowSum[row][column] = grid[row][column] + grid[row][column + 1] + grid[row][column + 2];
            }
        }

        for (int row = 0; row < rows - 2; row++) {
            for (int column = 0; column < columns; column++) {
                colSum[row][column] = grid[row][column] + grid[row + 1][column] + grid[row + 2][column];
            }
        }

        int count = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int column = 0; column < columns - 2; column++) {
                if (grid[row][column] >= 1 && grid[row][column] <= 9) {
                    int targetSum = rowSum[row][column];
                    boolean nextTwoRowMatches = rowSum[row + 1][column] == targetSum
                            && rowSum[row + 2][column] == targetSum;
                    boolean nextTwoColMatches = colSum[row][column + 1] == targetSum
                            && colSum[row][column + 2] == targetSum;
                    boolean diagMatches = validateDiag(grid, row, column, targetSum);
                    if (nextTwoRowMatches && nextTwoColMatches && diagMatches && validateNums(grid, row, column)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean validateDiag(int[][] grid, int row, int column, int target) {
        int forwardSum = grid[row][column] + grid[row + 1][column + 1] + grid[row + 2][column + 2];
        int backSum = grid[row + 2][column] + grid[row + 1][column + 1] + grid[row][column + 2];
        return forwardSum == target && backSum == target;
    }

    private boolean validateNums(int[][] grid, int row, int column) {
        Set<Integer> set = new HashSet<>();
        for(int i = row; i< row + 3; i++) {
            for(int j = column; j< column + 3; j++) {
                int num = grid[i][j];
                if(num < 1 || num > 9 || set.contains(num)) {
                    return false;
                }
                set.add(num);
            }
        }
        return true;
    }
}
