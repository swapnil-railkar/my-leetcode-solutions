package com.leetCode;

public class P1559 {
	public boolean solution(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean[][] visiting = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (dfs(visiting, visited, grid, row, col, -1, -1, grid[row][col])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] visiting, boolean[][] visited, char[][] grid, int row, int col, int fRow, int fCol,
            char curr) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        if (grid[row][col] != curr) {
            return false;
        }
        if (visiting[row][col]) {
            return true;
        }
        if (visited[row][col]) {
            return false;
        }

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // down, up, right, left
        visiting[row][col] = true;
        for (int[] d : dirs) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (newRow == fRow && newCol == fCol) {
                continue;
            }
            if (dfs(visiting, visited, grid, newRow, newCol, row, col, curr)) {
                return true;
            }
        }
        visiting[row][col] = false;
        visited[row][col] = true;
        return false;
    }
}
