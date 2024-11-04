package com.leetCode;

public class P4 {
	
	// This solution will run in (num1.length + num2.length) time
	public double solution(int[] num1, int[] num2) {
		int[] combination = new int[num1.length + num2.length];
		int n1Index = 0;
		int n2Index = 0;
		int index = 0;
	
		while(index < combination.length) {
			if (n1Index < num1.length && n2Index < num2.length) {
				if(num1[n1Index] < num2[n2Index]) {
					combination[index] = num1[n1Index];
					n1Index++;
				} else {
					combination[index] = num2[n2Index];
					n2Index++;
				}
			} else if (n1Index < num1.length) {
				combination[index] = num1[n1Index];
				n1Index++;
			} else if (n2Index < num2.length) {
				combination[index] = num2[n2Index];
				n2Index++;
			}
			index++;
		}
		
		if(combination.length % 2 == 0) {
			double midNum = (double)(combination[(combination.length / 2) - 1] + combination[combination.length / 2]);
			return midNum / 2;
		} else {
			return combination[combination.length / 2];
		}
	}
}
