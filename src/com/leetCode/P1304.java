package com.leetCode;

public class P1304 {
	public int[] solution(int n) {
        int[] ans = new int[n];
        if(n == 1) {
            ans[0] = 0;
            return ans;
        }
        ans[0] = n;
        for(int i = 1; i< ans.length; i++) {
            if(ans[i - 1] < 0 && i == ans.length - 1) {
                ans[i] = 0;
            } else if(ans[i - 1] > 0) {
                ans[i] = ans[i - 1] * -1;
                n--;
            } else {
                ans[i] = n;
            }
        }
        return ans;
    }
}
