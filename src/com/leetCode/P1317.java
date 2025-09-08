package com.leetCode;

public class P1317 {
	public int[] solution(int n) {
        for(int i = 0; i<= n/2 + 1; i++) {
            if(!containsZero(i)) {
                int rem = n - i;
                if(!containsZero(rem)) {
                    return new int[] {i, rem};
                }
            }
        }
        return new int[] {-1, -1};
    }

    private boolean containsZero(int num) {
        return String.valueOf(num).contains("0");
    }
}
