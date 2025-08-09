package com.leetCode;

public class P1143 {
	public int solution(String text1, String text2) {
        String small = text1.length() < text2.length() ? text1 : text2;
        String large = text1.length() >= text2.length() ?  text1 : text2;

        int[][] dp = new int[small.length()][large.length()];
        // fill first row.
        dp[0][0] = large.charAt(0) == small.charAt(0) ? 1 : 0;
        for(int i = 1; i< large.length(); i++) {
            if(small.charAt(0) == large.charAt(i)) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // fill first column.
        for(int i = 1; i< small.length(); i++) {
            if(small.charAt(i) == large.charAt(0)) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for(int row = 1; row< dp.length; row++) {
            for(int column = 1; column < dp[0].length; column++) {
                if(small.charAt(row) == large.charAt(column)) {
                    dp[row][column] = dp[row - 1][column - 1] + 1;
                } else {
                    dp[row][column] = Math.max(dp[row - 1][column], dp[row][column - 1]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
