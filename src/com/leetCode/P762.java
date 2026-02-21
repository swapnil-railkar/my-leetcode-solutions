package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P762 {
	public int solution(int left, int right) {
        Set<Integer> primes = new HashSet<>();
        int count = 0;
        for(int i = left; i<= right; i++) {
            String bin = Integer.toBinaryString(i);
            int oneCount = 0;
            for(int j = 0; j< bin.length(); j++) {
                if(bin.charAt(j) == '1') {
                    oneCount++;
                }
            }
            if(primes.contains(oneCount)) {
                count++;
            } else if(isPrime(oneCount)) {
                count++;
                primes.add(oneCount);
            }
        }
        return count;
    }

    private boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        int limit = (int) Math.sqrt(num);
        for(int i = 2; i<= limit; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
