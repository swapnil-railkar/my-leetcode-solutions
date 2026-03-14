package com.leetCode;

public class P633 {
	public boolean solution(int c) {
        long start = 0;
        long end = (long) Math.sqrt(c);
        while(start <= end) {
            long sum = start*start + end*end;
            if(sum == c) {
                return true;
            } else if(sum > c) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}
