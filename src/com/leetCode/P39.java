package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> comb = getCombinations(nums, target);
        System.out.println(comb);
	}

	private static List<List<Integer>> getCombinations(int[] nums, int target) {
		// TODO Auto-generated method stub
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> comb;
		Arrays.sort(nums);
		for(int i=0; i< nums.length; i++) {
			comb = getComb(i,nums,target);
			if(!comb.isEmpty()) {
				list.add(comb);
			}
		}
		return list;
	}

	private static List<Integer> getComb(int index,int[] nums,int target) {
		// TODO Auto-generated method stu
		List<Integer> list = new ArrayList<>();
		int sum = target;

		while(sum > 0) {
			
		}
		return list;
	}

}
