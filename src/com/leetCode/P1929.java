package com.leetCode;

public class P1929 {
	public int maxSideLength(int[][] mat, int threshold) {
        int maxLength = 0;
        for(int row = 0; row < mat.length; row++) {
            for(int col = 0; col < mat[0].length; col++) {
                int length = getMaxLength(mat, row, col, threshold);
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }

    private int getMaxLength(int[][] mat, int row, int col, int threshold) {
        if(mat[row][col] > threshold) {
            return 0;
        }
        int length = 1;
        int rows = mat.length;
        int cols = mat[0].length;
        int tot = mat[row][col];
        while(row + length < rows && col + length < cols) {
            // add extra row to total.
            int extraRow = row + length;
            for(int i = col; i< col + length; i++) {
                tot += mat[extraRow][i];
            }
            for(int i = row; i< row + length; i++) {
                tot += mat[i][col + length];
            }

            tot += mat[row + length][col + length];

            if(tot > threshold) {
                break;
            }
            length++;
        }
        return Math.min(length, rows);
    }
}
