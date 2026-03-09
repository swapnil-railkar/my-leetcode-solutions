package com.leetCode;

import java.util.Arrays;

public class P1887 {
	public int solution(int[] nums) {
		Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for(int i = 0; i< n; i++) {
            int curr = nums[i];
            while(i < n && curr == nums[i]) {
                i++;
            }
            if(i < n) {
                count += (n - i);
                i--;
            }
        }
        return count;
    }
}
