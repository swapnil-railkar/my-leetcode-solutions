package com.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P1863 {

	public int solution(int[] nums) {
		int total = 0;
        for(int i=0; i< nums.length; i++) {
        	total += nums[i] + getAllSubsetTotalForIndex(i, nums.length, nums);
        	
        }
        return total;
    }
	
	private int getAllSubsetTotalForIndex(int index, int limit, int[] nums) {
		int total = 0;
		Queue<List<Integer>> q = new LinkedList<>();
		
		// init q
		for(int i = index + 1; i< limit; i++) {
			List<Integer> subset = new ArrayList<>();
			subset.add(index);
			subset.add(i);
			q.add(subset);
		}
		
		// process q and populate subsets.
		while(!q.isEmpty()) {
			List<Integer> currSub = q.remove();
			total += getSubsetTotal(currSub, nums);
			int lastIndex = currSub.get(currSub.size() - 1);
			for(int i = lastIndex + 1; i < limit; i++) {
				List<Integer> newSub = new ArrayList<>(currSub);
				newSub.add(i);
				q.add(newSub);
			}
		}
		return total;
	}
	
	private int getSubsetTotal(List<Integer> subset, int[] nums) {
		int total = 0;
		for(int num : subset) {
			total ^= nums[num];
		}
		return total;
	}
}
