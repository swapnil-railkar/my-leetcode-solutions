package com.leetCode;

import java.util.Arrays;

public class P1833 {
	public int solution(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        int i = 0;
        while(i < costs.length && coins >= costs[i]) {
            coins -= costs[i];
            count++;
            i++;
        }
        return count;
    }
}
