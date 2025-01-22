package com.leetCode;

import java.util.PriorityQueue;

public class P1765 {
	
	public int[][] solution(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		PriorityQueue<Wrapper> priorityQ = new PriorityQueue<>((a, b) -> a.value - b.value);
		int[][] answer = new int[rows][columns];
		
		// init 
		for(int row = 0; row< rows; row++) {
			for(int column = 0; column < columns; column++) {
				if(grid[row][column] == 1) {
					// make 1 to up
					if(row > 0 && grid[row - 1][column] != 1) {
						answer[row - 1][column] = 1;
						priorityQ.add(new Wrapper(1, row - 1, column));
					}
					// make 1 to down
					if(row < rows - 1 && grid[row + 1][column] != 1) {
						answer[row + 1][column] = 1;
						priorityQ.add(new Wrapper(1, row + 1, column));
					}
					// make 1 to left
					if(column > 0 && grid[row][column - 1] != 1) {
						answer[row][column - 1] = 1;
						priorityQ.add(new Wrapper(1, row, column - 1));
					}
					// make 1 to right
					if(column < columns - 1 && grid[row][column + 1] != 1) {
						answer[row][column + 1] = 1;
						priorityQ.add(new Wrapper(1, row, column + 1));
					}
				}
			}
		}
		
		while(!priorityQ.isEmpty()) {
			Wrapper cell = priorityQ.poll();
			int value = cell.value + 1;
			int row = cell.row;
			int column = cell.column;
			
			// fill up down left right with value + 1 if neighbor is 0 but not supposed to be 0
			// make value to up
			if(row > 0 && answer[row - 1][column] == 0 && grid[row - 1][column] == 0) {
				answer[row - 1][column] = value;
				priorityQ.add(new Wrapper(value, row - 1, column));
			}
			// make value to down
			if(row < rows - 1 && answer[row + 1][column] == 0 && grid[row + 1][column] == 0) {
				answer[row + 1][column] = value;
				priorityQ.add(new Wrapper(value, row + 1, column));
			}
			// make value to left
			if(column > 0 && answer[row][column - 1] == 0 && grid[row][column - 1] == 0) {
				answer[row][column - 1] = value;
				priorityQ.add(new Wrapper(value, row, column - 1));
			}
			// make value to right
			if(column < columns - 1 && answer[row][column + 1] == 0 && grid[row][column + 1] == 0) {
				answer[row][column + 1] = value;
				priorityQ.add(new Wrapper(value, row, column + 1));
			}
		}
		return answer;
	}
	
	private static class Wrapper {
		int value;
		int row;
		int column;
		
		Wrapper(int value, int row, int column) {
			this.value = value;
			this.row = row;
			this.column = column;
		}
	}

}
