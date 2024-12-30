package com.leetCode;

public class P75 {

	// straight forward counting sort application
	public void solution(int[] nums) {
		int[] colours = new int[3];
		
		// calculate count of each number
		for(int i = 0; i< nums.length; i++) {
			colours[nums[i]] = colours[nums[i]] + 1;
		}
		
		// fill first colours[0] indexes with 0
		for(int i =0; i < colours[0]; i++) {
			nums[i] = 0;
		}
		
		// fill next colours[1] indexes with 1
		for(int i = colours[0]; i < (colours[0] + colours[1]); i++) {
			nums[i] = 1;
		}
		
		// fill next colours[2] indexes with 2
		for(int i = (colours[0] + colours[1]); i < (colours[0] + colours[1] + colours[2]); i++) {
			nums[i] = 2;
		}
	}
}
