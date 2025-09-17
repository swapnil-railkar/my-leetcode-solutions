package com.leetCode;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class Question {
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		P2353 question = new P2353(
				new String[] {"emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"},
				new String[] {"snaxol","snaxol","snaxol","fajbervsj","fajbervsj"},
				new int[] {2,6,18,6,5}
		);
		question.changeRating("qnvseohnoe", 11);
		System.out.println(question.highestRated("fajbervsj"));
		question.changeRating("emgqdbo", 3);
		question.changeRating("jmvfxjohq", 9);
		question.changeRating("emgqdbo", 14);
		System.out.println(question.highestRated("fajbervsj"));
		System.out.println(question.highestRated("snaxol"));
		//List<Integer> answer = question.solution(new int[] {31,97561,97561,97561,97561,97561,97561,97561,97561});
		LocalDateTime endTime = LocalDateTime.now();
		//System.out.println(answer);
		//printTree(answer);
		System.out.println("Total time taken : " + Duration.between(startTime, endTime).toMillis() + " ms");
	}

	private static void printTree(TreeNode answer) {
		// TODO Auto-generated method stub
		if(answer == null) {
			return;
		}
		System.out.println(answer.val);
		printTree(answer.left);
		printTree(answer.right);
	}

}