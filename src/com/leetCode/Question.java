package com.leetCode;

import java.util.List;

public class Question {
	public static void main(String[] args) {
		P916 question = new P916();
		String str1[] = {"bcedecccdb","daeeddecbc","ecceededdc","edadadccea","ebacdedcea","eddabdacec","cddbecbeca","eeababedcc","bcaddcdbad","aeeeeabeea"};// ace
		String str2[] = {"cb","aae","ccc","ab","adc"};
		List<String> answer = question.solution(str1, str2);
		for(String n : answer) {
			System.out.print(n + "\t");
		}
	}

}