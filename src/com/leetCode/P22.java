package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P22 {
	public List<String> solution(int n) {
        List<String> ans = new ArrayList<>();
        createParanthesis(ans, "", 0, 0, n);
        return ans;
    }

    private void createParanthesis(List<String> result, String curr, int open, int close, int n) {
        if(curr.length() == n * 2) {
            result.add(curr);
            return;
        }

        if(open < n) {
            createParanthesis(result, curr + "(", open + 1, close, n);
        } 

        if(close < open) {
            createParanthesis(result, curr + ")", open, close + 1, n);
        }
    }
}
