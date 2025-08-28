package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P3446 {
	public int[][] solution(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int currCol = columns - 1;
        int currRow = 0;
        // sort top right.
        while(currCol > 0) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            List<int[]> diag = new ArrayList<>();
            int col = currCol;
            int row = 0;
            while(row < rows && col < columns) {
                pq.add(grid[row][col]);
                diag.add(new int[]{row, col});
                row++;
                col++;
            }
            for(int[] pos : diag) {
                grid[pos[0]][pos[1]] = pq.poll();
            }
            currCol--;
            currRow = 0;
        }

        currCol = 0;
        currRow = 0;
        // sort bottom left.
        while(currRow < rows) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
            List<int[]> diag = new ArrayList<>();
            int col = 0;
            int row = currRow;
            while(row < rows && col < columns) {
                pq.add(grid[row][col]);
                diag.add(new int[]{row, col});
                row++;
                col++;
            }
            for(int[] pos : diag) {
                grid[pos[0]][pos[1]] = pq.poll();
            }
            currRow++;
            currCol = 0;
        }

        return grid;
    }
}
