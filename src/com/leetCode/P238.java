package com.leetCode;

public class P238 {

	public int[] solution(int[] nums) {
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];
        pref[0] = nums[0];
        suff[nums.length - 1] = nums[nums.length - 1];
        for(int i =1; i< nums.length; i++) {
            pref[i] = pref[i - 1] * nums[i];
        }
        for(int i = nums.length - 2; i>=0; i--) {
            suff[i] = suff[i + 1] * nums[i];
        }
        int[] ans = new int[nums.length];
        ans[0] = suff[1];
        ans[nums.length - 1] = pref[nums.length - 2];
        for(int i = nums.length - 2; i>=1; i--) {
            ans[i] = suff[i + 1] * pref[i - 1];
        }
        return ans;
    }
}
