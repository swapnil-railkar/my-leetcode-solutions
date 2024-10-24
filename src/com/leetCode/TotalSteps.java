package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class TotalSteps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {5,3,4,4,7,3,6,11,8,5,11}; // 10,1,2,3,4,5,6,1,2,3 Expected : 6
        int steps = totalSteps(nums);
        System.out.println(steps);
	}

	private static int totalSteps(int[] nums) {
		// TODO Auto-generated method stub
		int steps = 0;
        int j, i=0;
        boolean modified = true;
        List<Integer> list = new ArrayList<>();
		while(modified == true) {
			modified = false;
			j = i+1;
			while( list.contains(j) && j< nums.length) {
				j++;
			}
			
			if(j < nums.length && nums[i] > nums[j]) {
				modified = true;
				j++;
		    }
			
			i=j;
			
			if(modified == true) {
				steps++;
			}else if(modified == false) {
				return steps;
			}
		}
		
		return steps;
	}

}
