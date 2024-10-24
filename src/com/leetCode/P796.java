package com.leetCode;

public class P796 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String og ="geeksforgeeks";
        String rt ="geeksgeeksfor";
        boolean op = checkString(og, rt);
        System.out.println(op);
	}

	private static boolean checkString(String og, String rt) {
		// TODO Auto-generated method stub
		boolean clk;
		int length = og.length();
		if(length <= 2) {
			if(og.equals(rt)) {
				return true;
			}else {
				return false;
			}
		}
		
		if(og.charAt(0) == rt.charAt(2)) {
			clk = true;
		}else {
			clk = false;
		}
		
		if(clk) {
			// if clockwise rot.
			for(int i=0;i< length; i++) {
				if(i+2 < length) {
					if(og.charAt(i)!= rt.charAt(i+2)) {
						return false;
					}
				}else {
					if(i < length-2) {
						if((og.charAt(i) != rt.charAt(0)) || (og.charAt(length-1) != rt.charAt(1))) {
							return false;
						}
					}
				}
			}
			return true;
		}else {
			// if anticlockwise rot.
			for(int i= length-1 ;i>=0; i--) {
				if(i-2 >=0) {
					if(og.charAt(i)!= rt.charAt(i-2)) {
						return false;
					}
				}else {
					if((og.charAt(1) != rt.charAt(length-1)) || (og.charAt(0) != rt.charAt(length-2))) {
						return false;
					}
				}
			}
			return true;
		}
	}

}
