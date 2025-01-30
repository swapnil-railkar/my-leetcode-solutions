package com.leetCode;

public class P287 {

    public int solution(int[] nums) {
        int count = 0;
        int currIndex = 0;
        for(int i=0; i< nums.length; i++) {
            if (i > 0) {
                if (nums[i] != nums[i-1]) {
                    count = 0;
                } else {
                    count++;
                }
            }

            if (count < 2) {
                nums[currIndex] = nums[i];
                currIndex++;
            }
        }
        return currIndex;
    }
}
