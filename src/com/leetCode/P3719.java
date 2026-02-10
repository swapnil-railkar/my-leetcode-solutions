package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P3719 {
	public int solution(int[] nums) {
        int maxLength = 0;
        for(int i =0; i< nums.length; i++) {
            Set<Integer> odds = new HashSet<>();
            Set<Integer> evens = new HashSet<>();
            for(int j = i; j< nums.length; j++) {
                if(nums[j] %2==0) {
                    evens.add(nums[j]);
                } else {
                    odds.add(nums[j]);
                }
                if(evens.size() == odds.size()) {
                    int length = j - i + 1;
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        return maxLength;
    }
}
