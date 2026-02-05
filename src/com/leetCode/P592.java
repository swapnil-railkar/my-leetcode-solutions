package com.leetCode;

public class P592 {
	public String fractionAddition(String expression) {
        int num = 0;
        int den = 1;
        int i = 0;
        while(i < expression.length()) {
            int sign = 1;
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }

            StringBuilder numBuilder = new StringBuilder();
            while(expression.charAt(i) != '/') {
                numBuilder.append(expression.charAt(i));
                i++;
            }
            i++;
            int n = Integer.valueOf(numBuilder.toString());
            n *= sign;

            StringBuilder denoBuilder = new StringBuilder();
            while(i < expression.length() && Character.isDigit(expression.charAt(i))) {
                denoBuilder.append(expression.charAt(i));
                i++;
            }
            int d = Integer.valueOf(denoBuilder.toString());

            num = (num * d) + (den * n);
            den = (den * d);

            int gcd = getGcd(Math.abs(num), den);
            num /= gcd;
            den /= gcd;
        }
        return num + "/" + den;
    }

    private int getGcd(int num1, int num2) {
        return num2 == 0 ? num1 : getGcd(num2, num1 % num2);
    }
}
