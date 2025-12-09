package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P3583 {
	public int solution(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		Map<Integer, Integer> numCountMap = new HashMap<>();
        long zeroCount = 0;
        long count = 0;
        int mod = 1_000_000_007;
        for(int num : nums) {
        	if(num == 0) {
        		zeroCount++;
        	} else {
        		numSet.add(num);
        		numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        	}
        }
        
        count += getZeroPairs(zeroCount, mod);
        Map<Integer, Integer> seen = new HashMap<>();
        
        for(int num : nums) {
        	int doubles = num * 2;
        	if(numCountMap.containsKey(doubles)) {
        		int before = seen.getOrDefault(doubles, 0);
        		int after = numCountMap.get(doubles) - before;
        		long contri = before * after;
        		count = (count + contri) % mod;
        	}
        	seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        
        return (int) count;
    }
	
	private int getZeroPairs(long zeroCount, int mod) {
		long combination = zeroCount % mod
                * ((zeroCount - 1) % mod) % mod
                * ((zeroCount - 2) % mod) % mod;
        long inv6 = 166666668L;
        long result = combination % mod * inv6 % mod;
        return (int) (result % mod);
	}
}
