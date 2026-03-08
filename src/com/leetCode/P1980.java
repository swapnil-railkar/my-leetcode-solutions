package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P1980 {
	public String solution(String[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums[0].length();

        for(String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }

        int maxNum = (int) Math.pow(2, n) - 1;
        for(int i = 0; i<= maxNum; i++) {
            if(!set.contains(i)) {
                StringBuilder bin = new StringBuilder(Integer.toBinaryString(i));
                while(bin.length() < n) {
                    bin.insert(0, "0");
                }
                return bin.toString();
            }
        }
        return "";
    }
}
