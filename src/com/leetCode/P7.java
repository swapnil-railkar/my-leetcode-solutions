package com.leetCode;

public class P7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num = 1534236469;
        int ans = getAns(num);
        System.out.println(ans);
	}

	private static int getAns(int num) {
		// TODO Auto-generated method stub
		String str = Integer.toString(num);
		int length = str.length()-1;
		if(str.charAt(str.length()-1) == '0') {
			length--;
		}
		String rev = "";
		if(num < 0) {
			rev+='-';
			for(int i = length; i>=1; i--) {
				rev+=str.charAt(i);
			}
		}else {
			
			for(int i = length; i>=0; i--) {
				rev+=str.charAt(i);
			}
		}
		
		
		try {
			int revNum = Integer.valueOf(rev);
			return revNum;
		}catch(Exception e) {
			return 0;
		}
		
	}
	

}
