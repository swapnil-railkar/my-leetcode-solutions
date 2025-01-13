package com.leetCode;

public class P3223 {
	
	public int solution(String str) {
		int[] letterCount = new int[26];
		
		for(int i =0 ; i< str.length(); i++) {
			int index = str.charAt(i) - 'a';
			letterCount[index] = letterCount[index] + 1;
		}
		
		int count = 0;
		for(int i=0; i< letterCount.length; i++) {
			count += getReducedTotal(letterCount[i]);
		}
		
		return count;
	}

	private int getReducedTotal(int count) {
		while(count >= 3) {
			int div = count / 3;
			int rem = count % 3;
			count = div + rem;
		}
		return count;
	}
}
