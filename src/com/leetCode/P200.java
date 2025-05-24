package com.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class P200 {
	public int solution(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int islands = 0;
        for(int row = 0 ; row< rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(grid[row][column] == '1' && !visited[row][column]) {
                    Queue<Wrapper> q = new LinkedList<>();
                    q.add(new Wrapper(row, column));
                    visited[row][column] = true;
                    exploreIsland(grid, visited, q);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    private void exploreIsland(char[][] grid, boolean[][] visited, Queue<Wrapper> q) {
        if(q.isEmpty()) {
            return;
        }
        Wrapper curr = q.remove();
        int row = curr.row;
        int column = curr.column;
        
        // up
        if(row > 0 && !visited[row - 1][column] && grid[row-1][column] == '1') {
            q.add(new Wrapper(row - 1, column));
            visited[row - 1][column] = true;
        }
        // down
        if(row < grid.length - 1 && !visited[row + 1][column] && grid[row + 1][column] == '1') {
            q.add(new Wrapper(row + 1, column));
            visited[row + 1][column] = true;
        }
        // left
        if(column > 0 && !visited[row][column - 1] && grid[row][column - 1] == '1') {
            q.add(new Wrapper(row, column - 1));
            visited[row][column - 1] = true;
        }
        // right
        if(column < grid[0].length - 1 && !visited[row][column + 1] && grid[row][column + 1] == '1') {
            q.add(new Wrapper(row, column + 1));
            visited[row][column + 1] = true;
        }
        exploreIsland(grid, visited, q);
    }
    
    private static class Wrapper {
        int row;
        int column;
        
        Wrapper(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
