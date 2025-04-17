package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P96 {

	public int solution(int num) {
		Map<Integer, Integer> countCombinationMap = new HashMap<>();
		countCombinationMap.put(0, 1);
		countCombinationMap.put(1, 1);
		return getSum(countCombinationMap, num);
	}

	private int getSum(Map<Integer, Integer> countCombinationMap, int num) {
		if(countCombinationMap.containsKey(num)) {
			return countCombinationMap.get(num);
		}
		int totSum = 0;
		for(int i = 1; i<= num; i++) {
			int leftRem = i - 1;
			int rightRem = num - i;

			int leftSum = getSum(countCombinationMap, leftRem);
			int rightSum = getSum(countCombinationMap, rightRem);
			totSum += leftSum * rightSum;
		}
		countCombinationMap.put(num, totSum);
		return totSum;
	}
}
