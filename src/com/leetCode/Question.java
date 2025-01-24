package com.leetCode;

import java.util.List;

public class Question {
	public static void main(String[] args) {
		P802 question = new P802();
		int[][] a = {
				{0,2,3,9},{0,3,5},{},{5,7,8,9},{5,6,7,8,9},{6,7,8,9},{7,8,9},{6,8,9},{4,9},{}
		};
		List<Integer> answer = question.solution(a);
		for(int n : answer) {
			System.out.println(n + "\t");
		}
		System.out.println(answer);
	}

}