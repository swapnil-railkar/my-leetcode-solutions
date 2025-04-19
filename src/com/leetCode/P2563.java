package com.leetCode;

import java.util.Arrays;

public class P2563 {

	public long solution(int[] arr, int lower, int upper) {
        long count = 0;
		Arrays.sort(arr);
		int startIndex = 0;
		int endIndex = arr.length - 1;
		for(int i =0; i< arr.length; i++) {
			if(arr[i] + arr[endIndex] >= lower) {
				startIndex = getStartIndex(i, arr, lower);
				endIndex = getEndIndex(endIndex, startIndex, i, arr, upper);
				if(startIndex <= endIndex) {
					count += (endIndex - startIndex) + 1;
				}
			}
		}

		return count;
    }

    private int getEndIndex(int endIndex, int startIndex, int currIndex, int[] arr, int upper) {
		while(endIndex >= startIndex && arr[currIndex] + arr[endIndex] > upper) {
			endIndex--;
		}
		return endIndex;
	}

	private int getStartIndex(int currIndex, int[] arr, int lower) {
		int index = currIndex + 1;
		while(index < arr.length && arr[currIndex] + arr[index] < lower) {
			index++;
		}
		return index;
	}

}
