package com.leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P2257 {
	public int countUnguarded(int rows, int columns, int[][] guards, int[][] walls) {
        Set<List<Integer>> wallSet = new HashSet<>();
         boolean[][] isGuarded = new boolean[rows][columns];
        for (int[] wall : walls) {
            isGuarded[wall[0]][wall[1]] = true;
            wallSet.add(List.of(wall[0], wall[1]));
        }
        Set<List<Integer>> guardSet = new HashSet<>();
        for (int[] guard : guards) {
            guardSet.add(List.of(guard[0], guard[1]));
        }

        for (int[] guard : guards) {
            int row = guard[0];
            int column = guard[1];
            //go left.
            while (column >= 0) {
                isGuarded[row][column] = true;
                column--;
                if (guardSet.contains(List.of(row, column)) || wallSet.contains(List.of(row, column))) {
                    break;
                }
            }
            row = guard[0];
            column = guard[1];
            //go right.
            while (column < columns) {
                isGuarded[row][column] = true;
                column++;
                if (guardSet.contains(List.of(row, column)) || wallSet.contains(List.of(row, column))) {
                    break;
                }
            }
            row = guard[0];
            column = guard[1];
            //go up.
            while (row >= 0) {
                isGuarded[row][column] = true;
                row--;
                if (guardSet.contains(List.of(row, column)) || wallSet.contains(List.of(row, column))) {
                    break;
                }
            }
            row = guard[0];
            column = guard[1];
            //go down.
            while (row < rows) {
                isGuarded[row][column] = true;
                row++;
                if (guardSet.contains(List.of(row, column)) || wallSet.contains(List.of(row, column))) {
                    break;
                }
            }
        }

        int count = 0;
        for(int row = 0; row< rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(!isGuarded[row][column]) {
                    count++;
                }
            }
        }
        return count;
    }
}
