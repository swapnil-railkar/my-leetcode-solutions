package com.leetCode;

public class P33 {
	public int solution(int[] nums, int key) {
        int start = 0;
        int end= nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == key) {
                return mid;
            }else if(nums[start] <= nums[mid]) {
                // left half is sorted
                if(nums[start] <= key && key < nums[mid]) {
                    // key is in left half.
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // right half is sorted.
                if(nums[end] >= key && key > nums[mid]) {
                    // key is in right half.
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
