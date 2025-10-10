package com.leetCode;

public class P3147 {
	public int solution(int[] energy, int k) {
        int[] pref = new int[energy.length];

        // init.
        for(int i = 0; i< k; i++) {
            pref[i] = energy[i];
        }

        // fill array.
        for(int i = k ;i< pref.length; i++) {
            pref[i] = Math.max(energy[i], pref[i - k] + energy[i]);
        }

        int max = Integer.MIN_VALUE;
        // find max.
        for(int i = pref.length - 1; i >= pref.length - k; i--) {
            max = Math.max(max, pref[i]);
        }
        return max;
    }
}
