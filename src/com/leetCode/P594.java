package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P594 {
	public int solution(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for(int num : nums) {
            numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for(int key : numCountMap.keySet()) {
            if(numCountMap.containsKey(key - 1)) {
                count = Math.max(count, numCountMap.get(key) + numCountMap.get(key - 1));
            }
        }
        return count;
    }
}
