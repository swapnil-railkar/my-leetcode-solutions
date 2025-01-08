package com.leetCode;

public class P3042 {
	
	public int solution(String[] words) {
		int count = 0;
	    for(int i =0; i< words.length; i++) {
	        String currWord = words[i];
	        for(int j = i+1; j< words.length; j++) {
	            if(isPrefixAndSuffix(currWord, words[j])) {
	                count++;
	            }
	        }
	    }
	    return count;
	}
	
	private boolean isPrefixAndSuffix(String str1, String str2) {
        if(str1.length() <= str2.length()) {
            return isPrefix(str1, str2) && isSuffix(str1, str2);
        }
        return false;
    }

    private boolean isPrefix(String str1, String str2) {
        for(int prefixIndex = 0, strIndex = 0; prefixIndex< str1.length(); prefixIndex++, strIndex++) {
            if(str1.charAt(prefixIndex) != str2.charAt(strIndex)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuffix(String str1, String str2) {
        for(int suffixIndex = str1.length() - 1, strIndex = str2.length() - 1; suffixIndex >= 0; suffixIndex--, strIndex--) {
            if(str1.charAt(suffixIndex) != str2.charAt(strIndex)) {
                return false;
            }
        }
        return true;
    }
}
