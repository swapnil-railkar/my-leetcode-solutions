package com.leetCode;

public class P313 {
	public int solution(int n, int[] primes) {
		int[] indexes = new int[primes.length];
        int[] ugly = new int[n];
        long[] temp = new long[primes.length];
        for(int i = 0; i< primes.length; i++) {
            temp[i] = primes[i];
        }
        ugly[0] = 1;
        for(int i = 1; i< n; i++) {
            long min = Long.MAX_VALUE;
            for(int j = 0; j< primes.length; j++) {
                min = Math.min(temp[j], min);
            }
            ugly[i] = (int) min;
            for(int j = 0;j< primes.length; j++) {
                if(temp[j] == min) {
                    indexes[j]++;
                    temp[j] = primes[j] * (long) ugly[indexes[j]];
                }
            }
        }
        return ugly[n - 1];
    }
}
