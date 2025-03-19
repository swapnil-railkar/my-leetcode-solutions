package com.leetCode;

public class P3191 {
	
	public int solution(int[] arr) {
		int count = 0;
		for(int i =0; i<= arr.length - 3; i++) {
			if(arr[i] == 0) {
				arr[i] = 1;
				arr[i + 1] = negate(arr[i + 1]);
				arr[i + 2] = negate(arr[i + 2]);
				count++;
			}
		}
		if(arr[arr.length - 1] == 0 || arr[arr.length - 2] == 0) {
			return -1;
		}
		return count;
	}
	
	private int negate(int num) {
		return num == 0 ? 1 : 0;
	}
}
