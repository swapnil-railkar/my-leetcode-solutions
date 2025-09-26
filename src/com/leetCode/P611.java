package com.leetCode;

import java.util.Arrays;

public class P611 {
	public int solution(int[] nums) {
		Arrays.sort(nums);
        int count = 0;
        for(int k = nums.length - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while(i < j) {
                if(nums[i] + nums[j] > nums[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}
