package com.leetCode;

import java.util.List;

public class Question {
	public static void main(String[] args) {
		P1408 question = new P1408();
		String[] str = {"mass","as","hero","superhero"};// ace
		
		List<String> answer = question.solution(str);
		for(String n : answer) {
			System.out.print(n + "\t");
		}
	}

}