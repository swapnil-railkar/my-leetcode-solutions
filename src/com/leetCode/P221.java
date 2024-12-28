package com.leetCode;

public class P221 {

	public int solution(char[][] matrix) {
		int length = 0;
		for(int row =0; row< matrix.length; row++) {
			// count number of continuous 1's in row
			int oneCount = 0;
			int startColumn = 0;
			int endColumn = 0;
			for(int column = 0; column< matrix[0].length; column++) {
				if(matrix[row][column] == '1') {
					if(oneCount == 0) {
						startColumn = column;
					}
					oneCount++;
					if(oneCount > length) {
						endColumn = column;
					}
				}
				if(matrix[row][column] == '0') {
					if(oneCount > length) {
						length = getMaxLength(length, row, startColumn, endColumn, matrix);
					}
					oneCount = 0;
				}
			}
			// if row ended without zero
			if(oneCount > length) {
				length = getMaxLength(length, row, startColumn, endColumn, matrix);
			}
		}

		return length * length ;
	}

	// check if square exists between start column and end column
	private int getMaxLength(int length, int row, int startColumn, int endColumn, char[][] matrix) {
		// find how many rows of contious rows of 1s can be found in following rows
		int squareLength  = getMaxSquareLength(row, startColumn, endColumn, matrix);
		return Math.max(length, squareLength);
	}

	private int getMaxSquareLength(final int currRow, int startColumn, int endColumn, final char[][] matrix) {
		int expectedLength = 0;
		int completeSquares = 0;
		for(int row = currRow; row< matrix.length; row++) {
			expectedLength++;
			// update start column and end column by max subset of 1's in row
			int[] range = getRangeOfMaxSubsetOfOnes(startColumn, endColumn, matrix[row]);
			startColumn = range[0];
			endColumn = range[1];
			if(startColumn == -1 || endColumn == -1) {
				return completeSquares;
			}
			if((endColumn - startColumn) + 1 < expectedLength) {
				return completeSquares;
			} else {
				completeSquares++;
			}
		}

		return completeSquares;
	}

	private int[] getRangeOfMaxSubsetOfOnes(int startColumn, int endColumn, final char[] row) {
		int maxOnes = 0;
		int start = -1;
		int end = -1;
		int oneSeq = 0;
		int currStart  = 0;
		for(int i = startColumn; i<= endColumn; i++) {
			if(row[i] == '1') {
				if(oneSeq == 0) {
					currStart = i;
				}
				oneSeq++;
				if(oneSeq > maxOnes) {
					start = currStart;
					end = i;
					maxOnes = oneSeq;
				}
			} else if (row[i] == '0') {
				oneSeq = 0;
			}
		}
		return new int[] {start, end};
	}
}
