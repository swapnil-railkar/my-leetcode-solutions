package com.leetCode;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class Question {
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		P632 question = new P632();
		int a = 1;
		int b = 2;
		System.out.println(((double)a + (double) b) / 2);
		int[] answer = question.solution(Arrays.asList(
				Arrays.asList(1, 2, 3),
				Arrays.asList(1, 2, 3),
				Arrays.asList(1, 2, 3)
				));
		LocalDateTime endTime = LocalDateTime.now();
		System.out.println(answer[0] + " " + answer[1]);
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