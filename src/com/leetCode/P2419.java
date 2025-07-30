package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P2419 {
	public int solution(int[] nums) {
        int maxAnd = 1;
        int currAnd = 1, length = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (currAnd == num) {
                length++;
            } else {
                currAnd = num;
                maxAnd = Math.max(maxAnd, currAnd);
                length = 1;
            }

            if (currAnd == maxAnd) {
                map.put(maxAnd, Math.max(length, map.getOrDefault(maxAnd, 0)));
            }
        }
        return map.get(maxAnd);
    }
}
