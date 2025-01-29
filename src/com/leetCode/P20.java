package com.leetCode.String;

import java.util.Stack;

public class P20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s = "[";
       boolean balance = checkIfBalance(s);
       System.out.println(balance);
	}

	private static boolean checkIfBalance(String s) {
		// TODO Auto-generated method stub
		Stack<Character> stack = new Stack<>();
		try {
			for(int i=0; i< s.length(); i++) {
				char cr = s.charAt(i);
				if(isOpening(cr)) {
					stack.push(cr);
				}else {
					char top = stack.peek();
					if(cr == ')' && top == '(') {
						stack.pop();
					}else if(cr == ']' && top == '[') {
						stack.pop();
					}else if(cr == '}' && top == '{') {
						stack.pop();
					}else {
						stack.push(cr);
					}
				}
			}
			
			if(stack.isEmpty()) {
				return true;
			}
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}

	private static boolean isOpening(char cr) {
		// TODO Auto-generated method stub
		switch(cr) {
		case '(':return true;
		case '[':return true;
		case '{':return true;
		default:return false;
		}
	}

}
