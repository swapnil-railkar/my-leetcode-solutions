package com.leetCode;

public class P153 {

	public int solution(int[] nums) {
		return getMinNum(nums, 0, nums.length - 1);
	}

	private int getMinNum(int[] nums, int startIndex, int endIndex) {
		if(startIndex >= endIndex) {
			return nums[startIndex];
		} else if(endIndex - startIndex == 1) {
			return Math.min(nums[startIndex], nums[endIndex]);
		} else {
			int mid = (startIndex + endIndex) / 2;
			if(isMinNum(mid, nums)) {
				return nums[mid];
			} else if(nums[endIndex] < nums[startIndex] && nums[endIndex] < nums[mid]){
				// exists in right half
				return getMinNum(nums, mid + 1, endIndex);
			} else {
				// exists in left half
				return getMinNum(nums, startIndex, mid - 1);
			}
		}
	}

	// min num is num which have left and right both greater than num.
	private boolean isMinNum(int index, int[] nums) {
		if(nums[index] < nums[index - 1] && nums[index] < nums[index + 1]) {
			return true;
		}
		return false;
	}
}
