package com.leetCode;

public class Question {
	public static void main(String[] args) {
		P1769 question = new P1769();
		String str = "001011";// ace
		
		int[] answer = question.solution(str);
		for(int n : answer) {
			System.out.print(n + "\t");
		}
	}

}