package com.leetCode;

public class Question {
	public static void main(String[] args) {
		P75 question = new P75();
		int[] arr = {2,0,2,1,1,0};

		question.solution(arr);
		for(int n : arr) {
			System.out.println(n);
		}
		
	}

}