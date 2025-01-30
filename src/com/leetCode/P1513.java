package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P1513 {

    public int solution(String s) {
        List<Long> subsLength = new ArrayList<>();
        long count = 0;
        for (int i=0; i< s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else if (s.charAt(i) == '0') {
                if (count > 0) {
                    subsLength.add(count);
                }
                count = 0;
            }
        }

        if (count > 0) {
            subsLength.add(count);
        }

        return getSubsCount(subsLength);
    }

    private int getSubsCount(List<Long> subsLength) {
        long sum = 0;
        int mod = (int)Math.pow(10, 9) + 7;
        for (Long length : subsLength) {
            long subs = (length * (length + 1)) / 2;
            sum += subs;
        }
        return (int)(sum % mod);
    }
}
