package com.leetCode;

public class P162 {
	
	public int solution(int[] nums) {
		int index = nums.length / 2;
        while(index >= 0 && index < nums.length) {
            int left = (index - 1) >= 0 ? nums[index - 1] : Integer.MIN_VALUE;
            int right = (index + 1) < nums.length ? nums[index + 1] : Integer.MIN_VALUE;
            if(left <= nums[index] && right <= nums[index]) {
                // peak index found
                return index;
            } else if(left < nums[index] && right > nums[index]) {
                index++;
            } else if(left > nums[index] && right < nums[index]) {
                index--;
            } else {
                if(right > left) {
                    index++;
                } else {
                    index--;
                }
            }
        }
        return -1;
	}
}
