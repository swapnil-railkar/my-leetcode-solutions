package com.leetCode;

public class P2185 {
	public int solution(String[] words, String pref) {
        int count = 0;
        for(int i =0; i< words.length; i++) {
            String currStr = words[i];
            if(currStr.length() >= pref.length() && isPrefix(pref, currStr)) {
                count++;
            }
        }
        return count;
    }

    private boolean isPrefix(String pref, String str) {
        for(int prefIndex = 0, strIndex = 0; prefIndex < pref.length(); prefIndex++, strIndex++) {
            if(pref.charAt(prefIndex) != str.charAt(strIndex)) {
                return false;
            }
        }
        return true;
    }
}
