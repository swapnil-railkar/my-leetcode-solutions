package com.leetCode;

public class P2658 {

	public int solution(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		int maxFish = 0;
		for(int row=0; row< rows; row++) {
			for(int column = 0; column < columns; column++) {
				if(grid[row][column] > 0) {
					int fishForIndex = getFishCountForLocation(grid, row, column, 0);
					maxFish = Math.max(maxFish, fishForIndex);
				}
			}

		}
		return maxFish;
	}

	private int getFishCountForLocation(int[][] grid, int row, int column, int count) {
		int sum = count + grid[row][column];
		grid[row][column] = -1;
		// left count
		if(column + 1 < grid[0].length) {
			// can go left
			if(grid[row][column + 1] > 0) {
				sum = getFishCountForLocation(grid, row, column + 1, sum);
			}
		}
		// right count
		if(column - 1 >= 0) {
			// can go right
			if(grid[row][column - 1] > 0) {
				sum = getFishCountForLocation(grid, row, column - 1, sum);
			}
		}
		// up count
		if(row - 1 >= 0) {
			// can go up
			if(grid[row - 1][column] > 0) {
				sum = getFishCountForLocation(grid, row - 1, column, sum);
			}
		}
		// down count
		if(row + 1 < grid.length) {
			// can go down
			if(grid[row + 1][column] > 0) {
				sum = getFishCountForLocation(grid, row + 1, column, sum);
			}
		}
		return sum;
	}

}
