package com.leetCode;

public class Question {
	public static void main(String[] args) {
		P2657 question = new P2657();
		int[] a = {1,3,2,4};
		int[] b = {3,1,2,4};
		int[] answer = question.solution(a,b);
		for(int n : answer) {
			System.out.print(n + "\t");
		}
		System.out.println(answer);
	}

}