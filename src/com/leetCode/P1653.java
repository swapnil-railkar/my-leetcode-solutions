package com.leetCode;

public class P1653 {
	public int solution(String s) {
        int n = s.length();
        int[] bBefore = new int[n];
        int[] aAfter = new int[n];
        int aCount = 0;
        int bCount = 0;

        for(int i = 0, j = n - 1; i< n && j >=0; i++, j--) {
            aAfter[j] = aCount;
            bBefore[i] = bCount;
            if(s.charAt(i) == 'b') {
                bCount++;
            } 
            if(s.charAt(j) == 'a') {
                aCount++;
            }
        }

        int minSum = Integer.MAX_VALUE;
        for(int i = 0; i< n; i++) {
            minSum = Math.min(aAfter[i] + bBefore[i], minSum);
        }
        return minSum;
    }
}
