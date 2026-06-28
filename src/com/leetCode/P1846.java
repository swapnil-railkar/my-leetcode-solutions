package com.leetCode;

import java.util.Arrays;

public class P1846 {
	public int solution(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        int max = 1;
        for(int i = 1; i< arr.length; i++) {
            if(Math.abs(arr[i - 1] - arr[i]) > 1) {
                arr[i] = arr[i - 1] + 1; 
            }
            max = Math.max(max, arr[i]);
        } 
        return max;
    }
}
