package com.leetCode;

public class P1411 {
	public int solution(int n) {
        int mod = 1_000_000_007;
        long same = 6; // ABA scenario
        long diff = 6; // ABC scenario

        for (int i = 2; i <= n; i++) {
            long newSame = (same * 3 + diff * 2) % mod;
            long newDiff = (same * 2 + diff * 2) % mod;

            same = newSame;
            diff = newDiff;
        }

        return (int) ((same + diff) % mod);
    }
}
