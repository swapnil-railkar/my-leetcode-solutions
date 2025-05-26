package com.leetCode;

import java.util.Stack;

public class P150 {
	public int solution(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                stk.push(num);
            } catch(Exception e) {
                int num2 = stk.pop();
                int num1 = stk.pop();
                int result = getResult(num1, num2, token);
                stk.push(result);
            }
        }
        return stk.peek();
    }
    
    private int getResult(int num1, int num2, String token) {
        switch(token) {
            case "+" : return num1 + num2;
            case "-" : return num1 - num2;
            case "/" : return num1 / num2;
            case "*" : return num1 * num2;
            default : return -1;
        }
    }
}
