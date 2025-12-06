package com.leetCode;

public class P91 {
	public int solution(String s) {
		int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0) {
                int num = Integer.parseInt(s.charAt(i - 2) + "" + s.charAt(i - 1));
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}
