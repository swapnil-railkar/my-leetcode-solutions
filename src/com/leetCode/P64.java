package com.leetCode;


public class P64 {

    public int solution(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        int[][] sumGrid = new int[rows][columns];
        sumGrid[0][0] = grid[0][0];

        for (int row = 0 ; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if ((row - 1) >= 0 && (column - 1) >= 0) {
                    int minNum = Math.min(sumGrid[row - 1][column], sumGrid[row][column - 1]);
                    sumGrid[row][column] = minNum + grid[row][column];
                } else if (row - 1 >= 0) {
                    sumGrid[row][column] = sumGrid[row - 1][column] + grid[row][column];
                } else if (column - 1 >= 0) {
                    sumGrid[row][column] = sumGrid[row][column - 1] + grid[row][column];
                }
            }
        }

        return sumGrid[grid.length - 1][grid[0].length - 1];
    }
}
