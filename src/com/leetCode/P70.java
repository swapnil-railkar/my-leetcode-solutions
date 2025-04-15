package com.leetCode;

public class P70 {

	public int solution(int n) {
		int[] arr = new int[n];
		return getMinSteps(n, 0, arr);
	}
	
	private int getMinSteps(int target, int num, int[] arr) {
		if(num == target) {
			return 1;
		} else if (num + 2 > target) {
			if(arr[num] == 0) {
				arr[num] = getMinSteps(target, num + 1, arr);
			}
			return arr[num];
		} else {
			if(arr[num] == 0) {
				int leftSum = getMinSteps(target, num + 1, arr);
				int rightSum = getMinSteps(target, num + 2, arr);
				arr[num] = leftSum + rightSum;
			}
			return arr[num];
		}
	}

}
