package com.leetCode;

public class Question {
	public static void main(String[] args) {
		P221 question = new P221();
		String[][] matrix = {
				{"1","0","1","1","1","1","1","1","1","1","1","1","1","1","1"},
				{"1","1","1","0","1","1","1","1","1","1","1","1","1","1","1"},
				{"1","1","1","0","0","0","1","0","1","1","1","1","1","1","1"},
				{"1","1","1","1","1","1","0","1","1","1","1","1","1","1","1"},
				{"1","1","1","1","1","1","1","0","1","1","1","1","1","0","1"}
		};
		char[][] arr = getCharArray(matrix);

		int maxSquare = question.solution(arr);
		System.out.println("Answer = " + maxSquare);
	}

	private static char[][] getCharArray(String[][] matrix) {
		char[][] arr = new char[matrix.length][matrix[0].length];

		for(int i=0; i< matrix.length; i++) {
			for(int j=0; j< matrix[0].length; j++) {
				arr[i][j] = matrix[i][j].charAt(0);
			}
		}

		return arr;
	}

}