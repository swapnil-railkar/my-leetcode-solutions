package com.leetCode;

public class Question {
	public static void main(String[] args) {
		P684 question = new P684();
		int[][] a = {{20,24},{3,17},{17,20},{8,15},{14,17},{6,17},{15,23},
				{6,8},{15,19},{16,22},{7,9},{8,22},{2,4},{4,11},{22,25},{6,24},
				{13,19},{15,18},{1,9},{4,9},{4,19},{5,10},{4,21},{4,12},{5,6}};
		int[] answer = question.solution(a);

		for(int n : answer) {
			System.out.print(n + "\t");
		}
	}

}