package com.leetCode;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


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
		int squareLength  = getMaxSquareLength(row, startColumn, endColumn, matrix, 0, new HashSet<>());
		return Math.max(length, squareLength);
	}

	private int getMaxSquareLength(final int currRow, int startColumn, int endColumn,
			final char[][] matrix, int expectedLength, Set<Integer> completedSquares) {
		int completeSquare = 0;
		expectedLength++;
		List<int[]> ranges = getSubArrayStartEndIndexes(startColumn, endColumn, matrix[currRow]);
		for(int[] range: ranges) {
			if(range[0] == -1 || range[1] == -1) {
				completedSquares.add(completeSquare);
			} else if((range[1] - range[0]) + 1 < expectedLength) {
				completedSquares.add(completeSquare);
			} else {
				completeSquare = expectedLength;
				completedSquares.add(completeSquare);
				if(currRow == matrix.length - 1) {
					return getMaxLength(completedSquares);
				}
				getMaxSquareLength(currRow + 1, range[0], range[1], matrix, expectedLength, completedSquares);
			}
		}
		return getMaxLength(completedSquares);
	} 
	
	private int getMaxLength(Set<Integer> completedSquares) {
		int maxLength = Integer.MIN_VALUE;
		for(int length : completedSquares) {
			if(length > maxLength) {
				maxLength = length;
			}
		}
		return maxLength;
	}

	private List<int[]> getSubArrayStartEndIndexes(final int startColumn, final int endColumn, final char[] row) {
		List<int[]> rangeList = new ArrayList<>();
		int start = -1;
		int end = -1;
		for(int i= startColumn; i<= endColumn; i++) {
			if(row[i] == '1' ) {
				if(start == -1) {
					start = i;
				}
				end = i;
			}
			if(row[i] == '0') {
				if(start!= -1) {
					rangeList.add(new int[] {start, end});
					start = -1;
				}
			}
		}

		if(start != -1) {
			// if array ends without 0.
			rangeList.add(new int[] {start, endColumn});
		}
		return rangeList;
	}
}
