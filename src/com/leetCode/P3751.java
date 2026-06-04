package com.leetCode;

public class P3751 {
	public int solution(int num1, int num2) {
        int total = 0;
        for(int i = num1; i<= num2; i++) {
            total += getWave(i);
        }
        return total;
    }

    private int getWave(int num) {
        String numStr = String.valueOf(num);
        int wave = 0;
        for(int i = 1; i< numStr.length() - 1; i++) {
            int curr = numStr.charAt(i);
            int prev = numStr.charAt(i - 1);
            int next = numStr.charAt(i + 1);
            if(curr < next && curr < prev) {
                wave++;
            } else if(curr > next && curr > prev) {
                wave++;
            }
        }
        return wave;
    }
}
