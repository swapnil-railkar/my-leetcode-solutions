package com.leetCode;

public class P3 {
	
	public int solution(String s) {
        int max = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right++) {
        	left = getLeftIndex(s, left, right, s.charAt(right));
        	max = Math.max(max, right - left + 1);
        }
        return max;
	}

	private int getLeftIndex(String str, int start, int end, char ch) {
		int leftIndex = start;
		for(int i = start; i< end; i++) {
			if(str.charAt(i) == ch) {
				leftIndex = i + 1;
			}
		}
		return leftIndex;
	}

}
