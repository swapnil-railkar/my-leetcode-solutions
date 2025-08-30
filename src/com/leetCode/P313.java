package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P313 {
	public int solution(int n, int[] primes) {
        if (n == 1) return 1;
        Set<Integer> pSet = new HashSet<>();
        for(int num : primes) {
            pSet.add(num);
        }
        pSet.add(1);
        int count = 1;
        int num = 2;
        while(count < n) {
            Set<Integer> primeFactors = getPrimeFactors(num);
            if(isSuperUgly(pSet, primeFactors)) {
                count++;
            }
            num++;
        }
        return num;
    }

    private boolean isSuperUgly(Set<Integer> primes, Set<Integer> factors) {
        for(int factor : factors) {
            if(!primes.contains(factor)) {
                return false;
            }
        }
        return true;
    }

    private Set<Integer> getPrimeFactors(int num) {
        Set<Integer> factors = new HashSet<>();
        while(!isPrime(num)) {
            int factor = getMinPrimeFactor(num);
            factors.add(factor);
            num /= factor;
        }
        factors.add(num);
        return factors;
    }

    private int getMinPrimeFactor(int num) {
        int i = 2;
        while(i <= num && !(isPrime(i) && num % i == 0)) {
            i++;
        }
        return i;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return true;
        for(int i = 2; i<= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
