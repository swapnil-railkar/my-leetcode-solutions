package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P2044 {
	public int countMaxOrSubsets(int[] nums) {
        Map<Integer, Integer> orCountMap = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            int count = orCountMap.getOrDefault(nums[i], 0) + 1;
            orCountMap.put(nums[i], count);
            updateMapForSubset(i + 1, orCountMap, nums, nums[i]);
        }
        int maxOr = Integer.MIN_VALUE;
        for(int or : orCountMap.keySet()) {
            maxOr = Math.max(or, maxOr);
        }
        return orCountMap.get(maxOr);
    }

    private void updateMapForSubset(int index, Map<Integer, Integer> orCountMap, int[] nums, int or) {
        if(index < nums.length) {
            // do not count current index in xor, increase.
            updateMapForSubset(index + 1, orCountMap, nums, or);
            // count current index in xor, update and increase.
            or |= nums[index];
            int count = orCountMap.getOrDefault(or, 0) + 1;
            orCountMap.put(or, count);
            updateMapForSubset(index + 1, orCountMap, nums, or);
        }
    }
}
