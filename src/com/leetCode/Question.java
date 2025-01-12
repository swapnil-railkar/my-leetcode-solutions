package com.leetCode;

public class Question {
	public static void main(String[] args) {
		P2116 question = new P2116();
		String brackets = "()))";
		String editable = "0010";
		boolean answer = question.solution(brackets, editable);
		System.out.println(answer);
	}

}