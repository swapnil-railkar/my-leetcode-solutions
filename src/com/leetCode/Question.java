package com.leetCode;

import java.util.List;

public class Question {
	public static void main(String[] args) {
		P1462 question = new P1462();
		int[][] a = {
			{3,2},{3,0},{2,0}, {1,3}
		};
		int[][] b = {
				{1,0},{1,2}
			};
		List<Boolean> answer = question.solution(4,a,b);
		for(boolean n : answer) {
			System.out.print(n + "\t");
		}
	}

}