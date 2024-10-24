package com.leetCode;

public class P1017 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num =47;
        String binary = convert(num);
        System.out.println(binary);
	}

	private static String convert(int num) {
		// TODO Auto-generated method stub
		String rem = "",ans = "";
		while(num != 0) {
			rem += String.valueOf(num % 2);
			num = num/2;
		}
		
		for(int i=rem.length()-1; i>=0; i--) {
			ans+=rem.charAt(i);
		}
		
		return ans;
	}

}
