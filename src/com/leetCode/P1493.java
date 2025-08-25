package com.leetCode;

public class P1493 {
	public int solution(int[] nums) {
        int max = 0;
        int left = 0;
        int zeroCount = 0;
        int oneCount = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 1) {
                oneCount++;
                max = Math.max(max, oneCount);
            } else {
                zeroCount++;
                if(zeroCount > 1) {
                    while(left < right && zeroCount > 1) {
                        if(nums[left] == 1) {
                            oneCount--;
                        } else {
                            zeroCount--;
                        }
                        left++;
                    }
                }
            }
        }
        return max == nums.length ? max - 1 : max;
    }
}
