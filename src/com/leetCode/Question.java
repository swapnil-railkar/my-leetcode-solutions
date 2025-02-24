package com.leetCode;

import java.time.Duration;
import java.time.LocalDateTime;

import com.leetCode.DsNodes.TreeNode;

public class Question {
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		P889 question = new P889();
		int[] preOrder = {1,2,4,5,3,6,7};
		int[] postOrder = {4,5,2,6,7,3,1};
		TreeNode answer = question.solution(preOrder, postOrder);
		LocalDateTime endTime = LocalDateTime.now();
		printTree(answer);
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