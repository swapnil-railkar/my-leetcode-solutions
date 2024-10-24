package com.leetCode;

public class MaxContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {1,1};
        int max = getMaxCont(arr);
        System.out.println(max);
	}

	private static int getMaxCont(int[] arr) {
		// TODO Auto-generated method stub
		int area = 0;
		int maxArea = area;
		int length, breadth;
		for(int i=0; i< arr.length; i++) {
			breadth = 0;
			for(int j=i; j< arr.length; j++) {
				length = Math.min(arr[i], arr[j]);
				area = length*breadth;
				if(area > maxArea) {
					maxArea = area;
				}
				breadth++;
			}
		}
		return maxArea;
	}

}
