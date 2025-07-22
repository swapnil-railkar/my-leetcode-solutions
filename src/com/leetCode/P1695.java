package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P1695 {
	public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0;
        Set<Integer> cache = new HashSet<>();
        int sum = 0, max = 0;
        while(right < nums.length) {
            if(cache.contains(nums[right])) {
                while(!cache.isEmpty() && cache.contains(nums[right])) {
                    sum -= nums[left];
                    cache.remove(nums[left]);
                    left++;
                } 
            }
            cache.add(nums[right]);
            sum += nums[right];
            max = Math.max(max, sum);
            right++;
        }
        return max;
    }
}
