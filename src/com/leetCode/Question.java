package com.leetCode;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class Question {
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		P3508 question = new P3508(3);
		System.out.println(question.addPacket(1,4,90));
		System.out.println(question.addPacket(2,5,90));
		System.out.println(question.addPacket(1,4,90));
		System.out.println(question.addPacket(3,5,95));
		System.out.println(question.addPacket(4,5,105));
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