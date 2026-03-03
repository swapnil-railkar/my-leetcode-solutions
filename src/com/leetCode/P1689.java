package com.leetCode;

public class P1689 {
	public int solution(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            char ch = n.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int d = ch - '0';
                if (d > max) max = d;
            }
        }
        return max;
    }
}
