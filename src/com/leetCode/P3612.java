package com.leetCode;

public class P3612 {
	public String solution(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder rev = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '%') {
                StringBuilder temp = ans;
                ans = rev;
                rev = temp;
            } else if (c == '#') {
                StringBuilder dupans = new StringBuilder(ans);
                ans.append(dupans);
                StringBuilder duprev = new StringBuilder(rev);
                rev.append(duprev);
            } else if (c == '*') {
                if (ans.length() > 0) {
                    ans.deleteCharAt(ans.length() - 1);
                    rev.deleteCharAt(0);
                }
            } else {
                ans.append(c);
                rev.insert(0, c);
            }
        }
        return ans.toString();
    }
}
