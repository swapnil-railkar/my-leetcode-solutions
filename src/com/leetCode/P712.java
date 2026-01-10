package com.leetCode;

public class P712 {
	public int solution(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // init last column 
        for (int i = s1.length() - 1; i >= 0; i--) {
            dp[i][s2.length()] = dp[i + 1][s2.length()] + s1.charAt(i);
        }
        // init last row
        for (int j = s2.length() - 1; j >= 0; j--) {
            dp[s1.length()][j] = dp[s1.length()][j + 1] + s2.charAt(j);
        }
        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    // no deletion required.
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    // keep s1[i], delete s2[j];
                    int delS2 = (int) s2.charAt(j) + dp[i][j + 1];
                    // keep s2[j], delete s1[i];
                    int delS1 = (int) s1.charAt(i) + dp[i + 1][j];
                    dp[i][j] = Math.min(delS1, delS2);
                }
            }
        }
        return dp[0][0];
    }
}
