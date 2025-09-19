package com.leetCode;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class Question {
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		P3484 question = new P3484(3);
		System.out.println(question.getValue("=5+7"));
		question.setCell("A1", 10);
		System.out.println(question.getValue("=A1+6"));
		question.setCell("B2", 15);
		System.out.println(question.getValue("=A1+B2"));
		question.resetCell("A1");
		System.out.println(question.getValue("=A1+B2"));
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