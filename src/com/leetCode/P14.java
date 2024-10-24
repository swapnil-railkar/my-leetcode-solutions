package com.leetCode;

public class P14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] arr = {"flower","flow","flight"};
        String prefix = findPrefix(arr);
        if(prefix.isBlank()) {
        	System.out.println("Nothing");
        }
        System.out.println(prefix);
	}

	private static String findPrefix(String[] arr) {
		// TODO Auto-generated method stub
		String prefix = arr[0];
		
		for(int i=1; i< arr.length; i++) {
			prefix = getCommon(prefix,arr[i]);
			if(prefix.isBlank()) {
				return "";
			}
		}
		
		return prefix;
	}

	private static String getCommon(String prefix, String string) {
		// TODO Auto-generated method stub
		String common = "";
		
		if(prefix.isBlank()) {
			return "";
		}
		
		for(int i =0; i< prefix.length() && i < string.length(); i++) {
			if(prefix.charAt(i) == string.charAt(i)) {
				common+=prefix.charAt(i);
			}else {
				break;
			}
		}
		return common;
	}

}
