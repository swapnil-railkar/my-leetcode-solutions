package com.leetCode;

public class P852 {
	public int solution(int[] arr) {
        if(arr[0] > arr[1]) {
            return 0;
        }
        int start = 1;
        int end = arr.length - 1;
        int maxIndex = -1;
        while(start <= end) {
            int mid = (start + end)/2;
            if(arr[mid] > arr[mid - 1]) {
                maxIndex = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return maxIndex;
    }
}
