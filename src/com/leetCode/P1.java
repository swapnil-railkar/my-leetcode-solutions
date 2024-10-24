package com.leetCode;

public class P1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr = {3,2,4};
        int target = 6;
        int[] ans = getAns(arr,target);
        System.out.println(ans[0]+" "+ans[1]);
	}

	private static int[] getAns(int[] arr, int target) {
		// TODO Auto-generated method stub
		int[] ans = new int[2];
		int temp = 0;
		for(int i=0; i< arr.length; i++) {
			temp = target - arr[i];
			for(int j=i+1; j< arr.length; j++) {
				if(arr[j] == temp) {
					ans[0] = i;
					ans[1] = j;
				}
			}
		}
		return ans;
	}

}
