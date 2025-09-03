package com.leetCode;

public class P34 {
	public int[] solution(int[] nums, int target) {
        int leftIndex = getLeftIndex(nums, target);
        int rightIndex = getRightIndex(nums, target);
        return new int[] {leftIndex, rightIndex};
    }
    
    private int getLeftIndex(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    private int getRightIndex(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
