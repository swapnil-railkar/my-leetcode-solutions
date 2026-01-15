package com.leetCode;

import java.util.Arrays;

public class P2943 {
	public int solution(int horizontals, int verticals, int[] hBars, int[] vBars) {
        int vGap = getMaxGap(vBars);
        int hGap = getMaxGap(hBars);
        int side = Math.min(vGap, hGap);
        return side*side;
    }

    private int getMaxGap(int[] bars) {
        Arrays.sort(bars);
        int max = 1;
        int count = 1;
        for(int i = 1; i< bars.length; i++) {
            if(bars[i] == bars[i - 1] + 1) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
        }
        return max + 1;
    }
}
