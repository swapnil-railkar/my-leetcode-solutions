package com.leetCode;

public class P2429 {
	
	public int solution(int num1, int num2) {
		String num1Bin = Integer.toBinaryString(num1);
		String num2Bin = Integer.toBinaryString(num2);
		
		int c1n1 = countOnes(num1Bin);
		int c1n2 = countOnes(num2Bin);
		
		if(c1n1 == c1n2) {
			return num1;
		} else if(c1n1 < c1n2) {
			// add ones 
			int diff = c1n2 - c1n1;
			String ans = addOnes(num1Bin, diff);
			return Integer.parseInt(ans, 2);
		} else {
			// remove ones
			int diff = c1n1 - c1n2;
			String ans = removeOnes(num1Bin, diff);
			return Integer.parseInt(ans, 2);
		}
	}

	private int countOnes(final String binaryNum) {
		int count = 0;
		for(int i = 0; i< binaryNum.length(); i++) {
			if(binaryNum.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
	
	private String removeOnes(final String binaryNum, int n) {
		StringBuffer lesserNum = new StringBuffer(binaryNum);
		int removedNums = 0;
		for(int i=binaryNum.length() - 1; i >= 0 && removedNums < n; i--) {
			if(binaryNum.charAt(i) == '1') {
				lesserNum.setCharAt(i, '0');
				removedNums++;
			}
		}
		return lesserNum.toString();
	}
	
	private String addOnes(final String binaryNum, int n) {
		StringBuffer greaterNum = new StringBuffer(binaryNum);
		int addedNums = 0;
		for(int i=binaryNum.length() - 1; i >= 0 && addedNums < n; i--) {
			if(binaryNum.charAt(i) == '0') {
				greaterNum.setCharAt(i, '1');
				addedNums++;
			}
		}
		if(addedNums < n) {
			int rem = n - addedNums;
			StringBuffer extraOnes = new StringBuffer();
			for(int i = 0; i< rem; i++) {
				extraOnes.append('1');
			}
			extraOnes.append(greaterNum);
			return extraOnes.toString();
		}
		return greaterNum.toString();
	}
}
