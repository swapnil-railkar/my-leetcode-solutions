package com.leetCode;

public class P6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "AB";
        int rows = 3;
        String ans = getAns(s,rows);
        System.out.println(ans);
    }

	private static String getAns(String s, int rows) {
		// TODO Auto-generated method stub
		if(rows == 1 || rows >= s.length()) {
			return s;
		}
		String ans ="";
		int diag = rows - 2;
		int ptrOne = rows + diag;
		int ptrTwo = 0;
		int ptr;
		for(int i=1; i<=rows;i++) {
			ans = ans+s.charAt(i-1);
			ptr = i-1;
			for(int j =0; ptr< s.length();j++) {
				if( j%2 == 0) {
				  if(i == 1 || i == rows) {
					  ptr+= ptrOne + ptrTwo;
				  }else {
					  ptr+= ptrOne;
				  }
				  
				  if(ptr < s.length()) {
					  ans = ans+s.charAt(ptr);
				  }
				  
				}else {
					if( i== 1 || i == rows) {
						ptr+= ptrOne + ptrTwo;
					}else {
						ptr+= ptrTwo;
					}
				  
				  if(ptr < s.length()) {
					  ans = ans+s.charAt(ptr);
				  }
				  
				}
			}
			ptrTwo += 2;
			ptrOne =(rows+diag)- ptrTwo;
			
		}
		return ans;
	}

}
