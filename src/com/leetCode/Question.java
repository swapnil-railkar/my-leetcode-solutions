package com.leetCode;

import java.time.Duration;
import java.time.LocalDateTime;

import com.leetCode.DsNodes.TreeNode;

public class Question {
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		P2379 question = new P2379();
		int answer = question.solution("WBBWWBBWBW", 7);
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println(answer);
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