package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P3697 {
	public int[] solution(int n) {
        String nums = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< nums.length(); i++) {
            int pow = nums.length() - (i + 1);
            int num = Character.getNumericValue(nums.charAt(i)) * (int) Math.pow(10, pow);
            if(num > 0) {
                list.add(num);
            }
        }
        int[] ans = new int[list.size()];
        int i = 0;
        for(int val : list) {
            ans[i++] = val;
        }
        return ans;
    }
}
