package com.leetCode;

public class P392 {
	public boolean solution(String subs, String str) {
        int subsIndex = 0;
        int strIndex = 0;
        while(subsIndex < subs.length() && strIndex < str.length()) {
            if(str.charAt(strIndex) == subs.charAt(subsIndex)) {
                subsIndex++;
            }
            strIndex++;
        }
        return subsIndex == subs.length();
    }
}
