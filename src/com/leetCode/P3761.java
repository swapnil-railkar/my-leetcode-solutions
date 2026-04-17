package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P3761 {
	public int solution(int[] nums) {
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indices = numIndexMap.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            numIndexMap.put(nums[i], indices);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            String numStr = Integer.toString(nums[i]);
            String rev = new StringBuilder(numStr).reverse().toString();
            int revNum = Integer.parseInt(rev);
            int closest = getClosestIndex(i, numIndexMap.getOrDefault(revNum, new ArrayList<>()));
            if(closest != Integer.MAX_VALUE) {
                int dist = Math.abs(i - closest);
                min = Math.min(min, dist);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int getClosestIndex(int target, List<Integer> indices) {
        int left = 0;
        int right = indices.size() - 1;
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = indices.get(mid);

            if (midVal > target) {
                result = midVal; 
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
