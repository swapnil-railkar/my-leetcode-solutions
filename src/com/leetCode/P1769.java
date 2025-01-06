package com.leetCode;

public class P1769 {

	public int[] solution(String str) {
		int[] moves = new int[str.length()];
		
		for(int i=0; i< str.length(); i++) {
			int totalMoves = 0;
			// left moves
			for(int j = 0; j< i; j++) {
				if(str.charAt(j) == '1') {
					totalMoves += (i - j);
				}
			}
			
			// right moves
			for(int j = str.length() - 1; j > i; j--) {
				if(str.charAt(j) == '1') {
					totalMoves += (j - i);
				}
			}
			moves[i] = totalMoves;
		}
		return moves;
	}
}  
