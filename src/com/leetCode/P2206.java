package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P2206 {

	public boolean solution(int[] nums) {
		Set<Integer> unpairedNums = new HashSet<>();

        for(int i = 0; i< nums.length; i++) {
            if(unpairedNums.contains(nums[i])) {
                unpairedNums.remove(nums[i]);
            } else {
                unpairedNums.add(nums[i]);
            }
        }
        return unpairedNums.isEmpty();
	}
}
