package com.leetCode;

public class P8 {

	public int solution(String s) {
        s = s.trim();
        if(s.isEmpty() || !Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+') {
            return 0;
        }
        int index = s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0;
        int num = 0;
        boolean isPos = s.charAt(0) != '-';
        while(index < s.length() && Character.isDigit(s.charAt(index))) {
        	int digit = Character.getNumericValue(s.charAt(index));
        	if (num > (Integer.MAX_VALUE - digit) / 10) {
                return !isPos ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num = num * 10 + digit;
            index++;
        }
        return !isPos ? num * -1 : num;
    }
}
