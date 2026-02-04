package com.leetCode;

public class P443 {
	public int solution(char[] chars) {
		int index = 0;
        int right = 0;
        for (int left = 0; left < chars.length; left++) {
            while (right < chars.length && chars[left] == chars[right]) {
                right++;
            }
            String count = Integer.toString(right - left);
            chars[index++] = chars[left];
            if (Integer.parseInt(count) > 1) {
                for (int i = 0; i < count.length() && index < chars.length; i++) {
                    chars[index++] = count.charAt(i);
                }
            }
            left = right - 1;
        }
        return index;
    }
}
