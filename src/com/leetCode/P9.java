package com.leetCode;

public class P9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num = 1234567899;
        boolean pal = isPallindrome(num);
        System.out.println(pal);
	}

	private static boolean isPallindrome(int num) {
		// TODO Auto-generated method stub
		if(num < 0) {
			return false;
		}else if(num == 0) {
			return true;
		}
		
		int tmp = num;
		int rem ; 
		String str = "";
		
		while(tmp > 0) {
			rem = tmp%10;
			tmp /= 10;
			str += String.valueOf(rem);
		}
		
		try {
			if(Integer.valueOf(str) == num) {
				return true;
			}
		}catch(Exception e) {
			return false;
		}
		
		
		return false;
	}

}
