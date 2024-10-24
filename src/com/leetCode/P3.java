package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "tmmzuxt";
        int num = longestString(s);
        System.out.println(num);
	}

	private static int longestString(String s) {
		// TODO Auto-generated method stub
		if(s.isEmpty()) {
			return 0;
		}
		List<Character> list;
		int length =1;
		int maxLength =length;
		
		for(int i =0 ; i< s.length();i++) {
			list = new ArrayList<>();
			list.add(s.charAt(i));
			length =1;
			for(int j = i+1; j< s.length(); j++){
				// if current character is already present in list then reset the list.
				if(list.contains(s.charAt(j))) {
					if(length > maxLength) {
						maxLength = length;
					}
					break;
					
				}else {
					// if current character is not present in list then update the list.
					length++;
					list.add(s.charAt(j));
					if(length > maxLength) {
						maxLength = length;
					}
				}
			}
			
		}
		return maxLength;
	}


}
