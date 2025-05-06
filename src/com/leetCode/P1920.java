package com.leetCode;

public class P1920 {
	public int[] solution(int[] nums) {
		int[] ans = new int[nums.length];
        for(int i = 0; i< nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }

//     Solution with O(1) extra space 
//     public int[] buildArray(int[] nums) {
//        int n = nums.length;
//
//        // encoding
//        for(int i =0; i< n; i++) {
//            nums[i] = nums[i] + n* (nums[nums[i]] % n);
//        }
//
//        // decoding
//        for(int i =0; i< n; i++) {
//            nums[i] = nums[i] / n;
//        }
//        return nums;
//    }
    
}
