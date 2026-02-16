package com.leetCode;

public class P190 {
	public int reverseBits(int n) {
        StringBuilder bin = new StringBuilder(Integer.toBinaryString(n));

        while(bin.length() < 32) {
            bin.insert(0, '0');
        }

        String rev = bin.reverse().toString();
        int sign = rev.charAt(0) == '0' ? 1 : -1;
        String revSub = rev.substring(1);
        return Integer.parseInt(revSub, 2) * sign;
    }
}
