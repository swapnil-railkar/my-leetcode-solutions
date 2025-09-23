package com.leetCode;

public class P165 {
	public int solution(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int maxIndex = Math.max(v1.length, v2.length);
        for(int i = 0; i< maxIndex; i++) {
            if(i < v1.length && i < v2.length) {
                int num1 = Integer.parseInt(v1[i]);
                int num2 = Integer.parseInt(v2[i]);
                if(num1 > num2) {
                    return 1;
                } else if(num1 < num2)  {
                    return -1;
                }
            } else if(i < v1.length) {
                int num = Integer.parseInt(v1[i]);
                if(num > 0) {
                    return 1;
                }
            } else if(i < v2.length) {
                int num = Integer.parseInt(v2[i]);
                if(num > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
