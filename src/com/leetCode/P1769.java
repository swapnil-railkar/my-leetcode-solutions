package com.leetCode;

public class P1769 {

	public int[] solution(String str) {
		int length = str.length();
		int[] rightSum = new int[length];
		int[] leftSum = new int[length];
		int rightTotal = 0;
		int leftTotal = 0;
		
		// calculate total sum from right to left
		for(int leftIndex = 0, rightIndex = length - 1; leftIndex < length && rightIndex >=0; leftIndex++, rightIndex--) {
			if(str.charAt(leftIndex) == '1') {
				leftTotal++;
			}
			if(str.charAt(rightIndex) == '1') {
				rightTotal++;
			}
			leftSum[leftIndex] = leftTotal;
			rightSum[rightIndex] = rightTotal;
		}
		
		// calculate total moves req for 0th index
		int totalMoves = 0;
		for(int i = length - 1; i > 0; i--) {
			if(str.charAt(i) == '1') {
				totalMoves += (i);
			}
		}
		rightSum[0] = totalMoves;
		
		// edit total according to total of first Index.
		for(int i = 1; i< rightSum.length; i++) {
			rightSum[i] = rightSum[i-1] - rightSum[i];
		}
	
		// calculate total moves req for (length)th index
		totalMoves = 0;
		for(int i = 0; i < length; i++) {
			if(str.charAt(i) == '1') {
				totalMoves += ((length - 1) - i);
			}
		}
		leftSum[length - 1] = totalMoves;
		
		// edit total according to total of last Index.
		for(int i = length - 2; i>=0; i--) {
			leftSum[i] = leftSum[i+1] - leftSum[i];
		}
		
		int[] moves = new int[length];
		
		for(int i =0; i< length; i++) {
			moves[i] = leftSum[i] + rightSum[i];
		}
		return moves;
	}
}  
