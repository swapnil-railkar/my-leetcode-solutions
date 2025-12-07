package com.leetCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P139 {
	public boolean solution(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordSet = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i = 1; i< dp.length; i++) {
            for(int j = 0; j< i; j++) {
                if(dp[j]) {
                    String subs = getSubString(s, j, i - 1);
                    if(wordSet.contains(subs)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }

    private String getSubString(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for(int i = start; i<= end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
