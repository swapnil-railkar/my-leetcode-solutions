package com.leetCode;

public class Question {
	public static void main(String[] args) {
		P1765 question = new P1765();
		int[][] a = {
				{0,0,0,0,0,0,1,0},
				{0,1,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,1,0},
				{0,0,1,0,0,0,0,0}
				};
		int[][] answer = question.solution(a);
		for(int[] row : answer) {
			for(int n : row) {
				System.out.println(n + "\t");
			}
			System.out.println();
		}
		System.out.println(answer);
	}

}