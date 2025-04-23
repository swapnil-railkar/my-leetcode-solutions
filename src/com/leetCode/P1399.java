package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P1399 {

	public int solution(int n) {
		Map<Integer, Integer> digitSumCountMap = new HashMap<>();
		Map<Integer, Integer> digitSumMap = new HashMap<>();
		digitSumMap.put(0, 0);
		for(int i = 1; i<= n; i++) {
			int digitSum = 0;
			if(i < 10) {
				digitSumMap.put(i, i);
				digitSum = i;
			} else {
				int sum = digitSumMap.get(i / 10) + (i % 10);
				digitSumMap.put(i, sum);
				digitSum = sum;
			}
			int digitSumCount = digitSumCountMap.getOrDefault(digitSum, 0) + 1;
			digitSumCountMap.put(digitSum, digitSumCount);
		}
		
		int maxCount = Integer.MIN_VALUE;
		int freq = 0;
		for(int key : digitSumCountMap.keySet()) {
			int count = digitSumCountMap.get(key);
			if(count == maxCount) {
				freq++;
			} else if(count > maxCount) {
				maxCount = count;
				freq = 1;
			}
		}
		return freq;
	}
}
