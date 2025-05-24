package com.leetCode;

public class P553 {
	public String solution(int[] nums) {
        if(nums.length == 1) {
            return Integer.toString(nums[0]);
        } else if(nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        String init = nums[0] + "/(";
        StringBuilder ans = new StringBuilder(init);
        for(int i = 1; i< nums.length; i++) {
            if(i == nums.length - 1) {
               String div = nums[i] + ")";
               ans.append(div);
            } else {
                String div = nums[i] + "/";
                ans.append(div);
            }
            
        }
        return ans.toString();
    }
}
