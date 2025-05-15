package com.leetCode;

public class P26 {

	public int removeDuplicates(int[] nums) {
        int lastModifiedIndex = 0;
        for(int i = 1; i< nums.length; i++) {
            if(nums[i] != nums[i - 1]) {
                nums[++lastModifiedIndex] = nums[i];
            }
        }
        return ++lastModifiedIndex;
    }

}
