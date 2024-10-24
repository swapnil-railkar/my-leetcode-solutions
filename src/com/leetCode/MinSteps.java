package com.leetCode;

import java.util.Arrays;

public class MinSteps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num = 4;
        int ans = getMinSteps(num);
        System.out.println(ans);
	}

	private static int getMinSteps(int n) {
		// TODO Auto-generated method stub
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 2;
		}else {
			return getMinSteps(n-1)+getMinSteps(n-2);
		}
	}

}
