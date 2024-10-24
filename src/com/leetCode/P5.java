package com.leetCode;

public class P5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "abssbd";
        String ans = longestPalindrome(s);
        System.out.println(ans);
        
	}

	private static String longestPalindrome(String s) {
		// TODO Auto-generated method stub

		String ans = "" ;
		if(s.length() == 1) {
			return ans+s.charAt(0);
		}
		
		for(int i=0; i< s.length(); i++) {
			for(int j = s.length()-1 ; j>i; j--) {
				if(s.charAt(i) == s.charAt(j)) {
					ans = checkIfPallindrome(i,j,s);
					if(!ans.isBlank()) {
						return ans;
					}
				}
			}
		}
		
		if(ans.isEmpty()) {
			return ans+s.charAt(0);
		}
		return ans;
	}
	
	public static String checkIfPallindrome(int first, int last, String s) {
		int mid = (first + last)/2;
		int flag = 0;
		String ans = "";
		
		for(int j =first ; j<= mid+1 && last!=first;j++) {
			if(s.charAt(j) != s.charAt(last)) {
				flag =1;
				break;
			}else {
				ans = ans+s.charAt(j);
			}
			last--;
		}
		if(flag == 0) {
			ans = ans+s.charAt(last);
		}else {
			ans = "";
		}
		return ans;
	}

}
