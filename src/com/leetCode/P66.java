package com.leetCode;

import java.util.Arrays;

public class P66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[] num = {0};
       int[] plusOne = addOne(num);
       System.out.println(Arrays.toString(plusOne));
	}

	private static int[] addOne(int[] num) {
		// TODO Auto-generated method stub
		
		int length = num.length -1;
		if(allNine(num)) {
			int[] newNum = new int[num.length +1];
			newNum[0] = 1;
			return newNum;
					
		}else if(num[length] != 9) {
			int n = num[length] +1;
			num[length] = n;
		}else {
			int i = length;
			while(num[i] == 9 && i >=0) {
				num[i] = 0;
				i--;
			}

			num[i] = num[i]+1;
		}
		return num;
	}

	private static boolean allNine(int[] num) {
		// TODO Auto-generated method stub
		for(int n : num) {
			if(n !=9) {
				return false;
			}
		}
		return true;
	}

}
