package com.leetCode;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class Question {
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		P840 question = new P840();
		int answer = question.solution(new int[][] {{7,6,2,2,4},{4,4,9,2,10},{9,7,8,3,10},{8,1,9,7,5},{7,10,4,11,6}});
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