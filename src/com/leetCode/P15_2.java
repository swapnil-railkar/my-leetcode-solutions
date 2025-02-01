package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P15_2 {

	public List<List<Integer>> solution(int[] nums) {
		Set<List<Integer>> candidates = new HashSet<>();
		Set<Integer> processedNums = new HashSet<>();
		Arrays.sort(nums);
		for(int i=0; i< nums.length; i++) {
			if(processedNums.contains(nums[i])) {
				continue;
			}
			for(int j=nums.length - 1; j> i ; j--) {
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
			processedNums.add(nums[i]);
		}
		return new ArrayList<>(candidates);
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
