package com.leetCode;

import java.util.Arrays;

public class P1 {

	public int[] solution(int[] nums, int target) {
		// TODO Auto-generated method stub
		int[] temp = new int[nums.length];
        for(int i =0; i< nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int first = -1;
        int second = -1;
        for(int i = 0; i< temp.length - 1; i++) {
            int rem = target - temp[i];
            if(elementExists(rem, i + 1, temp)) {
                first = temp[i];
                second = rem;
                break;
            }
        }
        if(first == -1 || second == -1) {
            return new int[] {-1, -1};
        } else {
            int[] ans = new int[2];
            ans[1] = -1;
            ans[0] = -1;
            for(int i = 0; i< nums.length; i++) {
                if(nums[i] == first || nums[i] == second) {
                    if(ans[0] == -1) {
                        ans[0] = i;
                    } else {
                        ans[1] = i;
                        return ans;
                    }
                }
            }
            return ans;
        }
	}
	
	private boolean elementExists(int key, int start, int[] nums) {
		int end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == key) {
                return true;
            } else if(key < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

}
