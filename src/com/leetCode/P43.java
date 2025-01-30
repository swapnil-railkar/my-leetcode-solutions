package com.leetCode;

public class P43 {

    public String solution(String num1, String num2) {
        String largeNum = num1, smallNum = num2;
        if (num2.length() > num1.length()) {
            largeNum = num2;
            smallNum = num1;
        }

        String multiplication = "";
        int numOfZeroes = 0;
        for (int smallNumIndex = smallNum.length() - 1; smallNumIndex >=0; smallNumIndex--) {
            String lineMultiplication = getMultiplication(largeNum, getNum(smallNum.charAt(smallNumIndex)));
            String num = addZeroes(lineMultiplication, numOfZeroes);
            multiplication = addStrings(num, multiplication);
            numOfZeroes++;
        }
        return trimAnswer(multiplication);
    }

    private String trimAnswer(String answer) {
        StringBuilder removeZeroes = new StringBuilder(answer);
        int index = 0;
        while (answer.charAt(index) == '0' && index < answer.length() - 1) {
            removeZeroes.deleteCharAt(0);
            index++;
        }

        return removeZeroes.toString();
    }

    private String addZeroes(String num, int count) {
        StringBuilder numBuilder = new StringBuilder(num);
        while (count > 0) {
            numBuilder.append("0");
            count--;
        }
        return numBuilder.toString();
    }

    private String getMultiplication(String num, int multiplier) {
        int carry = 0;
        StringBuilder multiplication = new StringBuilder();
        for (int i = num.length() - 1; i>=0; i--) {
            int mul = (getNum(num.charAt(i)) * multiplier) + carry;
            multiplication.insert(0, mul % 10);
            carry = mul / 10;
        }
        if (carry != 0) {
            return multiplication.insert(0, carry).toString();
        }
        return multiplication.toString();
    }

    private String addStrings(String num1, String num2) {
        String biggerString = num1;
        String smallerString = num2;
        if (num2.length() > num1.length()) {
            biggerString = num2;
            smallerString = num1;
        }
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int lastIndexBig = biggerString.length() - 1;
        int lastIndexSmall = smallerString.length() - 1;

        while (lastIndexBig >= 0 || lastIndexSmall >=0) {
            if (lastIndexSmall >= 0) {
                int sum = getNum(biggerString.charAt(lastIndexBig)) + getNum(smallerString.charAt(lastIndexSmall)) + carry;
                int num = sum % 10;
                carry = sum / 10;
                ans.insert(0, num);
                lastIndexBig--;
                lastIndexSmall--;
            } else {
                int sum = getNum(biggerString.charAt(lastIndexBig)) +  carry;
                int num = sum % 10;
                carry = sum / 10;
                ans.insert(0, num);
                lastIndexBig--;
            }
        }

        if (carry == 0) {
            return ans.toString();
        } else {
            return carry + ans.toString();
        }
    }

    private int getNum(char c) {
        return c - '0';
    }

}
