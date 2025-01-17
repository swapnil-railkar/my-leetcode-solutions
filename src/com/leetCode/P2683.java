package com.leetCode;

public class P2683 {
	
	public boolean solution(int[] derived) {
		// get original array from derived array.
        if(derived.length == 1) {
            return derived[0] == 0;
        }
        int[] original = new int[derived.length];
        original[original.length - 1] = 0;
        if (derived[derived.length - 1] == 1) {
            original[0] = 1;
        } else {
            original[0] = 0;
        }

        for (int i = 1; i < original.length - 1; i++) {
            if (derived[i - 1] == 0) {
                original[i] = original[i - 1];
            } else {
                original[i] = negate(original[i - 1]);
            }
        }

        return derived[derived.length - 2] == (original[original.length - 2] ^ original[original.length - 1]);
	}
	
	private int negate(int n) {
        if(n == 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
