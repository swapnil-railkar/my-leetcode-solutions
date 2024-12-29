package com.leetCode;

public class P162 {
	
	public int solution(int[] nums) {
		return getPeakNumIndex(nums, 0, nums.length - 1);
	}
	
	private int getPeakNumIndex(int[] nums, int startIndex, int endIndex) {
		if(startIndex >= endIndex) {
			if(isPeakNum(startIndex, nums)) {
				return startIndex;
			}
			return -1;
		} else {
			int mid = (startIndex + endIndex) / 2;
			if(isPeakNum(mid, nums)) {
				return mid;
			} else {
				int leftPeak = getPeakNumIndex(nums, startIndex, mid - 1);
				if(leftPeak == -1) {
					return getPeakNumIndex(nums, mid + 1, endIndex);
				} else {
					return leftPeak;
				}
			}
		}
	}
	
	private boolean isPeakNum(int index, int[] nums) {
		if(index == 0) {
			return nums[index] > nums[index + 1];
		} else if(index == nums.length - 1) {
			return nums[index] > nums[index - 1];
		} else {
			return nums[index] > nums[index + 1] && nums[index] > nums[index - 1];
		}
	}
}
