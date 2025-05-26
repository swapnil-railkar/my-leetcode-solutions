package com.leetCode;

public class P371 {
	public int solution(int a, int b) {
		while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a; 
    }
}
