package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P525 {
	public int solution(int[] nums) {
        int[] count = new int[nums.length];
        count[0] = nums[0] == 0 ? -1 : 1;
        Map<Integer, Integer> countIndexMap = new HashMap<>();
        countIndexMap.put(count[0], 0);
        int maxDist = 0;
        for(int right = 1; right< nums.length; right++) {
            if(nums[right] == 0) {
                count[right] = count[right - 1] - 1;
            } else {
                count[right] = count[right - 1] + 1;
            }
            if(count[right] == 0) {
                maxDist = Math.max(maxDist, right + 1);
            } else if(countIndexMap.containsKey(count[right])){
                int left = countIndexMap.get(count[right]) + 1;
                int dist = (right - left) + 1;
                maxDist = Math.max(maxDist, dist);
            } else {
                countIndexMap.put(count[right], right);
            }
        }
        return maxDist;
    }
}
