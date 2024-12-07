package com.leetCode;

public class P62 {

	// The pascal triangle approach
	public int solution(int rows, int columns) {
		int[][] matrix = new int[rows][columns];
		// poplate edges of matrix
		for(int i=0; i< rows; i++) {
			matrix[i][0] = 1;
		}
		
		for(int i=0; i< columns; i++) {
			matrix[0][i] = 1;
		}
		
		// populate contents of matrix column by column
		// start with row1 column1
		for(int column = 1; column < columns; column++) {
			for(int row = 1; row< rows; row++) {
				matrix[row][column] = matrix[row][column-1] + matrix[row-1][column];
			}
		}
	
		return matrix[rows - 1][columns - 1];
	}
	
}
