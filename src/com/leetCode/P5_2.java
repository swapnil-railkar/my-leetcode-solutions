package com.leetCode;

public class P5_2 {

    public String solution(String str) {
        String longestPal = String.valueOf(str.charAt(0));
        for (int startIndex = 0 ; startIndex < str.length(); startIndex++) {
            for (int endIndex = str.length() - 1; endIndex> startIndex;  endIndex--) {
                if (str.charAt(startIndex) == str.charAt(endIndex) && isPalindrome(str, startIndex, endIndex)) {
                    String subs =  str.substring(startIndex,endIndex + 1);
                    if (subs.length() > longestPal.length()) {
                        longestPal = subs;
                    }
                }
            }
        }

        return longestPal;
    }

    private boolean isPalindrome(String str, int startIndex, int endIndex) {
        int mid = (startIndex + endIndex) / 2;

        for (int i = startIndex, j = endIndex; i<= mid; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
