package com.leetCode;

import java.util.Arrays;

public class P2300 {
	public int[] solution(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];
        Arrays.sort(potions);
        for(int i =0; i< spells.length; i++) {
            int index = getIndex(potions, success, spells[i]);
            int count = potions.length - index;
            if(index == -1) {
                count = 0;
            }
            ans[i] = count;
        }
        return ans;
    }

    private int getIndex(int[] potions, long success, int curr) {
        int start = 0, end = potions.length - 1;
        int index = -1;
        while(start <= end) {
            int mid = (start + end)/2;
            long mul = (long) curr * potions[mid];
            if(mul >= success) {
                end = mid - 1;
                index = mid;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }
}
