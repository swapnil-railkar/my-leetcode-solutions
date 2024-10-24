package com.leetCode;

import java.util.Arrays;

public class P35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {1,2,3};
        int target = 1; // Expected : 0,0
        int[] range = getRange(nums,target);
        System.out.print(Arrays.toString(range));
	}

	private static int[] getRange(int[] nums, int target) {
		// TODO Auto-generated method stub
		int[] range = {-1,-1};
		int startIndex = -1, endIndex = -1, i, j;
		int index = getIndex(nums , target);
		if(index == -1) {
			return range;
		}
		
		i = index;
		while(i >= 0 && nums[i] == target) {
			startIndex = i;
			i--;
		}
		
		
		j = index;
		while(j < nums.length && nums[j] == target) {
			endIndex = j;
			j++;
		}
		
		
		range[0] = startIndex;
		range[1] = endIndex;
		return range;
	}

	private static int getIndex(int[] nums, int target) {
		// TODO Auto-generated method stub
		int low = 0;
		int high = nums.length-1, mid;
		
		while(low <= high) {
			mid = (low + high)/2;
			if(nums[mid] == target) {
				return mid;
			}else if(target > nums[mid]) {
				low = mid +1;
			}else {
				high = mid -1;
			}
		}
		return -1;
	}

}
