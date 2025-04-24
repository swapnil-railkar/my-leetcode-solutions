package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P2799 {
	
	public int solution(int[] nums) {
		Set<Integer> distinctNums = new HashSet<>();
		for(int num : nums) {
			distinctNums.add(num);
		}
		int total = 0;
		
		for(int i = 0; i< nums.length && (nums.length - i) >= distinctNums.size(); i++) {
			Set<Integer> distinctSub = new HashSet<>();
			int j = i;
			while(j < nums.length && distinctSub.size() != distinctNums.size()) {
				distinctSub.add(nums[j]);
				j++;
			}

            if(distinctSub.size() == distinctNums.size()) {
                total += (nums.length - j) + 1;
            }
		}
		
		return total;
	}
}
