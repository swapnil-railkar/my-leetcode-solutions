package com.leetCode;

public class P27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {1,3,5,6};
        int target = 2;
        int loc = getLoc(arr, target);
        System.out.println(loc);
	}

	private static int getLoc(int[] arr, int target) {
		// TODO Auto-generated method stub
		int start =0;
		int end = arr.length-1;
		int mid = (start + end)/2;
		
		while(start <= end) {
			mid = (start + end)/2;
			if(arr[mid] == target) {
				return mid;
			}
			if(target < arr[mid]) {
				end = mid -1;
			}
			if(target > arr[mid]) {
				start = mid +1;
			}
		}
		
        if(arr[mid] < target) {
        	return mid+1;
        }
		return mid;
	}

}
