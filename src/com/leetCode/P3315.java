package com.leetCode;

import java.util.List;

public class P3315 {
	public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i = 0; i< ans.length; i++) {
            ans[i] = findAns(nums.get(i));
        }
        return ans;
    }

    private int findAns(int target) {
        String bin = Integer.toBinaryString(target);
        for(int i = 0; i< bin.length(); i++) {
            if(bin.charAt(i) == '1') {
                StringBuilder sb = new StringBuilder(bin);
                sb.setCharAt(i, '0');
                int num = Integer.parseInt(sb.toString(), 2);
                if((num | (num + 1)) == target) {
                    return num;
                }
            }
        }
        return -1;
    }
}
