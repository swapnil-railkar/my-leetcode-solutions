package com.leetCode;

public class P1422 {

	public int solution(String str) {
		int maxSum = 0;
		int leftCount = 0;
		for(int i = 1; i< str.length(); i++) {
			if(str.charAt(i-1) == '0') {
				leftCount++;
			}
			int rightCount = 0;
			for(int j=i; j< str.length();j++) {
				if(str.charAt(j) == '1') {
					rightCount++;
				}
			}
			maxSum = Math.max(maxSum, (leftCount + rightCount));
		}
		return maxSum;
	}

}
