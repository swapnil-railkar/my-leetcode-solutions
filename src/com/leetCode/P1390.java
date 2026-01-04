package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1390 {
	public int solution(int[] nums) {
        Map<Integer, Integer> divSumMap = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (divSumMap.containsKey(num)) {
                ans += divSumMap.get(num);
            } else {
                Set<Integer> divs = new HashSet<>();
                int sum = 0;
                for (int i = 1; i <= Math.sqrt(num); i++) {
                    if (num % i == 0) {
                        divs.add(i);
                        sum += i;
                        if (i != (num / i)) {
                            divs.add(num / i);
                            sum += (num / i);
                        }
                    }
                }
                if (divs.size() == 4) {
                    ans+= sum;
                    divSumMap.put(num, sum);
                } else {
                    divSumMap.put(num, 0);
                }
            }
        }
        return ans;
    }
}
