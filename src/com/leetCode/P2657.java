package com.leetCode;

public class P2657 {
	
	public int[] solution(int[] A, int[] B) {
		int[] cache = new int[A.length];
        int[] count = new int[A.length];
        int sameNumsCount = 0;
        for(int i = 0; i< A.length; i++) {
            cache[A[i] - 1] = cache[A[i] - 1] + 1;
            if(cache[A[i] - 1] == 2) {
                sameNumsCount++;
            }
            cache[B[i] - 1] = cache[B[i] - 1] + 1;
            if(cache[B[i] - 1] == 2) {
                sameNumsCount++;
            }
            count[i] = sameNumsCount; 
        }

        return count;
    }
}
