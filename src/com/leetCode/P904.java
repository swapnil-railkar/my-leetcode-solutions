package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P904 {
	public int solution(int[] fruits) {
        int max = 0;
        int left = 0;
        Map<Integer, Integer> fruitCountMap = new HashMap<>();
        for(int right = 0; right< fruits.length; right++) {
            if(!fruitCountMap.containsKey(fruits[right]) && fruitCountMap.keySet().size() > 1) {
                while(left < right && fruitCountMap.keySet().size() > 1) {
                    int count = fruitCountMap.get(fruits[left]) - 1;
                    if(count == 0) {
                        fruitCountMap.remove(fruits[left]);
                    } else {
                        fruitCountMap.put(fruits[left], count);
                    }
                    left++;
                }
            }
            fruitCountMap.put(fruits[right], fruitCountMap.getOrDefault(fruits[right], 0) + 1);
            max = Math.max(max, (right - left) + 1);
        }
        return max;
    }
}
