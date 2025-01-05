package com.leetCode;

public class Question {
	public static void main(String[] args) {
		P2381 question = new P2381();
		String str = "abc";// ace
		int[][] shifts = {
				{0,1,0},{1,2,1},{0,2,1}	
		};
		String answer = question.solution(str, shifts);
		System.out.println(answer);
	}

}