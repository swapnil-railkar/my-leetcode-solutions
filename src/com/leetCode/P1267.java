package com.leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P1267 {
	
	public int countServers(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[] oneColumns = new int[columns];
        Set<List<Integer>> coordinates = new HashSet<>();

        // Redundant loop
        for(int i = 0; i< columns; i++) {
            oneColumns[i] = -1;
        } 

        for(int row = 0; row < rows; row++) {
            boolean hasOne = false;
            int prevOneIndex = -1;
            for(int column = 0; column < columns; column++) {
                if(grid[row][column] == 1) {
                    if(hasOne) {
                        coordinates.add(List.of(row, column));
                        coordinates.add(List.of(row, prevOneIndex));  
                    } else {
                        hasOne = true;
                        prevOneIndex = column;
                    }
                    if(oneColumns[column] != -1) {
                        coordinates.add(List.of(row, column));
                        coordinates.add(List.of(oneColumns[column], column));
                    }
                    oneColumns[column] = row;
                }
            }
        }
        return coordinates.size();
    }
}
