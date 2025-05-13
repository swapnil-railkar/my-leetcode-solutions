package com.leetCode;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class Question {
	public static void main(String[] args) {
		LocalDateTime startTime = LocalDateTime.now();
		P49 question = new P49();
		List<List<String>> answer = question.solution(new String[] {"cab","tin","pew","duh","may","ill","buy","bar","max","doc"});
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