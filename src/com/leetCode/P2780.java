package com.leetCode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2780 {

	public int solution(List<Integer> nums) {
		Map<Integer, Integer> numCountMap = new HashMap<>();
		int key = -1;
		for(int num : nums) {
			if(numCountMap.containsKey(num)) {
				numCountMap.put(num, numCountMap.get(num) + 1);
				if(numCountMap.get(num) > (nums.size() / 2)) {
					key = num;
				}
			} else {
				numCountMap.put(num, 1);
			}
		}
		
		if(key == -1) {
			return key;
		} else {
			int[] leftCount = new int[nums.size()];
			leftCount[0] = nums.get(0) == key ? 1 : 0;
			for(int i = 1; i< leftCount.length; i++) {
				leftCount[i] = nums.get(i) == key ? leftCount[i - 1] + 1 : leftCount[i - 1];
			}
			
			int[] rightCount = new int[nums.size()];
			rightCount[nums.size() - 1] = nums.get(nums.size() - 1) == key ? 1 : 0;
			for(int i = nums.size() - 2; i>= 0; i--) {
				rightCount[i] = nums.get(i) == key ? rightCount[i + 1] + 1 : rightCount[i + 1];
			}
			
			for(int i = 0; i< nums.size() - 1; i++) {
				int leftHalf = i + 1;
				int rightHalf = (nums.size() - 1) - i;
				if(leftCount[i] * 2 > leftHalf && rightCount[i + 1] * 2 > rightHalf) {
					return i;
				}
			}
 		}
		return -1;
	}
}
