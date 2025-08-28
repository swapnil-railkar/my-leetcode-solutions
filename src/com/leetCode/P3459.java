package com.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P3459 {
	final int[][] allDir = {{ -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 }};

    public int solution(int[][] grid) {
        int max = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int column = 0; column < grid[0].length; column++) {
                if(grid[row][column] == 1) {
                    max = Math.max(max, 1);
                    for(int[] dir : allDir) {
                        int newRow = row + dir[0];
                        int newColumn = column + dir[1];
                        if(validRow(newRow, grid) && validColumn(newColumn, grid) && grid[newRow][newColumn] == 2) {
                            int length = maxLength(grid, dir, newRow, newColumn, 1, 0, true, 1);
                            max = Math.max(max, length);
                        }
                    }
                }
            }
        }
        return max;
    }

    private int maxLength(int[][] grid, int[] dir, int row, int column, int length, int max, boolean canTurn, int prev) {
        if (validRow(row, grid) && validColumn(column, grid)) {
            if (grid[row][column] != 0 && grid[row][column] != 2) {
                return Math.max(length, max);
            }
            if (grid[row][column] == prev) {
                return Math.max(length, max);
            }
            length++;
            int curr = grid[row][column];
            if (!canTurn) {
                return maxLength(grid, dir, row + dir[0], column + dir[1], length, max, false, curr);
            }
            Set<int[]> dirSet = getDirSet(dir);
            for (int[] newDir : dirSet) {
                boolean dirChange = Arrays.equals(newDir, dir);
                int dirLength = maxLength(grid, newDir, row + newDir[0], column + newDir[1], length, max, dirChange,
                        curr);
                max = Math.max(dirLength, length);
            }
            return max;
        }
        return Math.max(length, max);
    }

    private Set<int[]> getDirSet(int[] dir) {
        Set<int[]> dirSet = new HashSet<>();
        int[] rev = {-1 * dir[0], -1 * dir[1]};
        for(int[] newDir : allDir) {
            if(!Arrays.equals(rev, newDir)) {
                dirSet.add(newDir);
            }
        }
        return dirSet;
    }

    private boolean validRow(int row, int[][] grid) {
        return row >= 0 && row < grid.length;
    }

    private boolean validColumn(int column, int[][] grid) {
        return column >= 0 && column < grid[0].length;
    }
}
