package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] arr = {-1,0,1,0};
       List<List<Integer>> list = getAns(arr);
       System.out.println(list);
	}

	private static List<List<Integer>> getAns(int[] arr) {
		// TODO Auto-generated method stub
		List<Integer> nums;
		List<List<Integer>> list = new ArrayList<>();
		int sum = 0;
		Arrays.sort(arr);
		
		for(int i=0; i< arr.length -1; i++) {
			nums = new ArrayList<>();
			sum = arr[i] + arr[i+1];
			int index = makeitZero(arr, sum,i+1);
			if(index != -1) {
				nums.add(arr[i]);
				nums.add(arr[i+1]);
				nums.add(arr[index]);
				if(!list.contains(nums)) {
					list.add(nums);
				}
				
			}
			sum =0;
		}
		
		return list;
	}
	
	private static int makeitZero(int[] arr, int sum, int curr) {
		for(int i=curr+1; i< arr.length; i++) {
			if(arr[i] + sum == 0) {
				return i;
			}
		}
		return -1;
	}

}
