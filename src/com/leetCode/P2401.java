package com.leetCode;

public class P2401 {
	
	public int solution(int[] arr) {
		int max = 1;
		for(int i = 0; i< arr.length; i++) {
			int j = i + 1;
            while(j < arr.length && allAnd(arr, i, j)) {
                j++;
            }
            int count = j - i;
            max = Math.max(max, count);
		}
		return max;
	}
	
	private boolean allAnd(int[] arr, int startIndex, int endIndex) {
        for(int i = startIndex; i<= endIndex; i++) {
            for(int j = i + 1; j <= endIndex; j++) {
                if((arr[i] & arr[j]) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

}
