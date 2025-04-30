package com.leetCode;

public class P1295 {
	public int solution(int[] nums) {
        int count = 0;
        for(int num : nums) {
            if(isEvenDigit(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean isEvenDigit(int num) {
        if(num < Math.pow(10, 1)) {
            return false;
        } else if(num < Math.pow(10, 2)) {
            return true;
        } else if(num < Math.pow(10, 3)) {
            return false;
        } else if(num < Math.pow(10, 4)) {
            return true;
        } else if(num < Math.pow(10, 5)) {
            return false;
        } else {
            return true;
        }
    }
}
