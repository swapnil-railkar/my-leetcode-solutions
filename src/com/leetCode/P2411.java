package com.leetCode;

import java.util.Arrays;

public class P2411 {
	public int[] solution(int[] nums) {
		int maxOr = 0;
        for(int n : nums) {
            maxOr |= n;
        }
        String orBin = Integer.toBinaryString(maxOr);
        String[] binArr = new String[nums.length];
        for(int i =0; i< nums.length; i++) {
            binArr[i] = String.format("%" + orBin.length() + "s", Integer.toBinaryString(nums[i])).replace(' ', '0');
        }
        int[][] dp = new int[nums.length][orBin.length()];
        // populate rightmost column.
        int lastIndex = orBin.length() - 1;
        while(lastIndex >= 0 && orBin.charAt(lastIndex) == '0') {
        	lastIndex--;
        }
        if(lastIndex < 0) {
            int[] arr = new int[nums.length];
            Arrays.fill(arr, 1);
            return arr;
        }
        dp[nums.length - 1][lastIndex] = binArr[nums.length - 1].charAt(lastIndex) == '1' ? nums.length - 1 : -1;
        for(int row = nums.length - 2; row >= 0; row--) {
        	char curr = binArr[row].charAt(lastIndex);
        	int value = curr == '1' ? row : dp[row + 1][lastIndex];
        	dp[row][lastIndex] = value;
        }
        
        for(int column = lastIndex - 1; column >= 0; column--) {
        	int lastOneIndex = -1;
        	for(int row = nums.length - 1; row >= 0; row--) {
        		char currCol = orBin.charAt(column);
        		if(currCol == '0') {
        			dp[row][column] = dp[row][column + 1]; 
        		} else {
        			char currRow = binArr[row].charAt(column);
        			if(currRow == '0') {
        				dp[row][column] = Math.max(dp[row][column + 1], lastOneIndex);
        			} else {
        				lastOneIndex = row;
        				dp[row][column] = Math.max(dp[row][column + 1], row);
        			}
        		}
        	}
        }
        
        int[] ans = new int[nums.length];
        for(int i = 0; i< ans.length; i++) {
            int value = dp[i][0] == -1 ? 1 : (dp[i][0] - i) + 1;
        	ans[i] = value;
        }
		return ans;
    }
}
