package com.leetCode;

public class Question {
    public static void main(String[] args) {
        P73 question = new P73();
        int[][] matrix = {
        		{0,1,2,0},{3,4,5,2},{1,3,1,5}
        };
        question.solution(matrix);
        for(int i=0 ; i< matrix.length; i++) {
        	for(int j=0; j< matrix[0].length; j++) {
        		System.out.print(matrix[i][j] + "\t");
        	}
        	System.out.println();
        }
    }

}