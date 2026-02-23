package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P1461 {
	public boolean hasAllCodes(String s, int k) {
        int expectedSize = (int) Math.pow(2, k);
        if(s.length() < expectedSize) {
            return false;
        }
        Set<String> bins = new HashSet<>();
        StringBuilder bin = new StringBuilder();
        //init window.
        for(int i = 0; i< k; i++) {
            bin.append(s.charAt(i));
        }
        bins.add(bin.toString());
        for(int i = 0; i<= s.length() - k; i++) {
            bin.deleteCharAt(0);
            bin.append(s.charAt(i + k - 1));
            bins.add(bin.toString());
            if(bins.size() >= expectedSize) {
                return true;
            }
        }
        return bins.size() >= expectedSize;
    }
}
