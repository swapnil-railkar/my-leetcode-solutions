package com.leetCode.String;

import java.util.Stack;

public class P32 {

    // TODO : Solve for TLE
    public int solution(String str) {
        int maxLength = 0;
        for (int startIndex=0; startIndex< str.length(); startIndex++) {
            for (int endIndex= str.length() - 1; endIndex > startIndex; endIndex--) {
                int length = (endIndex - startIndex) + 1;
                if (isValidParan(str, startIndex, endIndex) && length > maxLength) {
                    maxLength = length;
                }
            }
        }
        return maxLength;
    }

    private boolean isValidParan(String str, int startIndex, int endIndex) {
        Stack<Character> stk = new Stack<>();

        for (int i= startIndex; i<= endIndex; i++) {
            if (str.charAt(i) == '(') {
                stk.push('(');
            } else if (str.charAt(i) == ')') {
                if (stk.isEmpty()) {
                    return false;
                }
                stk.pop();
            }
        }

        return stk.isEmpty();
    }

}
