package com.leetCode.Arrays;

public class P1701 {
    public double getWaitingTime(int[][] num) {
        int chef = 0;
        double wait = 0;
        for (int i= 0; i< num.length; i++) {
            chef = Math.max(chef, num[i][0]) + num[i][1];
            wait += chef - num[i][0];
        }

        return wait/ num.length;
    }
}
