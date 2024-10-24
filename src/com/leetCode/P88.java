package com.leetCode;

import java.util.Arrays;

public class P88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] num1 = {1,2,3};
        int l1 = num1.length;
        
        int[] num2 = {2,5,6};
        int l2 = num2.length;
        
        printMergedArray(num1,num2,l1,l2);
	}

	private static void printMergedArray(int[] num1, int[] num2, int l1, int l2) {
		// TODO Auto-generated method stub
		int[] arr = new int[l1+l2];
		
		for(int i=0; i< l1; i++) {
			arr[i] = num1[i];
		}
		
		for(int i=l1,j=0;i< l1+l2; i++,j++) {
			arr[i] = num2[j];
		}
		
		num1 = arr;
		Arrays.sort(num1);
		System.out.println(Arrays.toString(num1));
	}

	

}
