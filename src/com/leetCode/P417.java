package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P417 {

	public List<List<Integer>> solution(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
		int rows = heights.length;
		int columns = heights[0].length;
		boolean[][] pacific = new boolean[rows][columns];
		boolean[][] atlantic = new boolean[rows][columns];
		// visit all cells that can go pacific and atlantic directly.
		for(int column = 0; column < columns; column++) {
			dfs(heights, 0, column, pacific, heights[0][column]);
            dfs(heights, rows - 1, column, atlantic,  heights[rows - 1][column]);
		}
		for(int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacific, heights[row][0]);
			dfs(heights, row, columns - 1, atlantic, heights[row][columns - 1]);
		}
		
		for(int row = 0; row< rows; row++) {
			for(int col = 0; col < columns; col++) {
				if(pacific[row][col] && atlantic[row][col]) {
					ans.add(List.of(row, col));
				}
			}
		}
		return ans;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited, int prev) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length) {
            return;
        }
        if(visited[row][col]) {
            return;
        }
        if(grid[row][col] < prev) {
            return;
        }
        visited[row][col] = true;
        int curr = grid[row][col];
        dfs(grid, row + 1, col, visited, curr); 
        dfs(grid, row - 1, col, visited, curr); 
        dfs(grid, row, col + 1, visited, curr);
        dfs(grid, row, col - 1, visited, curr);  
    }
}
