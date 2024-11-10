package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15 {
	
	public List<List<Integer>> solution(int[] nums) {
		List<List<Integer>> candidates = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0; i< nums.length; i++) {
			for(int j=i + 2; j< nums.length ; j++) {
				List<Integer> candidate = new ArrayList<>();
				int rem = (nums[i] + nums[j]) * -1;
				if (keyExists(nums, rem, i, j)) {
					candidate.add(nums[i]);
					candidate.add(nums[j]);
					candidate.add(rem);
				}
				if(!candidate.isEmpty() && !candidates.contains(candidate)) {
					candidates.add(candidate);
				}
			}
		}
		return candidates;
	}
	
	private boolean keyExists(int[] nums, int key, int startIndex, int endIndex) {
		int low = startIndex + 1;
		int high = endIndex - 1;
		int mid;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] == key) {
				return true;
			} else if(key < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;
	}

}
