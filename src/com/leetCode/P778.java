package com.leetCode;

import java.util.TreeMap;

public class P778 {
	public int swimInWater(int[][] grid) {
        TreeMap<Integer, int[]> valLocMap = new TreeMap<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                valLocMap.put(grid[row][col], new int[] {row, col});
            }
        }

        for(int key : valLocMap.keySet()) {
            int[] loc = valLocMap.get(key);
            boolean start = dfs(grid, loc[0], loc[1], new boolean[rows][cols], key, true);
            boolean end = dfs(grid, loc[0], loc[1], new boolean[rows][cols], key, false);
            if(start && end) {
                return key;
            }
        }
        return -1;
    }

    private boolean dfs(int[][] grid, int row, int col, boolean[][] visited, int maxReq, boolean start) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        if(visited[row][col]) {
            return false;
        }
        if(grid[row][col] > maxReq) {
            return false;
        }
        if(start && row == 0 && col == 0) {
            return true;
        }
        if(!start && row == grid.length - 1 && col == grid[0].length - 1) {
            return true;
        }
        visited[row][col] = true;
        return dfs(grid, row + 1, col, visited, maxReq, start)
        || dfs(grid, row - 1, col, visited, maxReq, start)
        || dfs(grid, row, col + 1, visited, maxReq, start)
        || dfs(grid, row, col - 1, visited, maxReq, start);
    }
}
