package com.leetCode;

import java.util.Arrays;

public class P781 {

	public int solution(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		
		for(int i =0; i< arr.length; i++) {
			int n = arr[i];
			int currCount = 0;
			// check whether next n indexes have same values as answers[i].
			int j = i;
			while(j < arr.length && currCount < n+1 && arr[i] == arr[j]) {
				currCount++;
				j++;
			}
			i = j - 1;
			count += n + 1;
		}
		return count;
	}
}
