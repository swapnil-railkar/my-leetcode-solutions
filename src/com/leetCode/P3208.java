package com.leetCode;

public class P3208 {

	public int solution(int[] arr, int k) {
		int count = 1;
        int groups = 0;
        int index = getLastRepeatingIndex(arr);
        if(index == -1) {
            return arr.length;
        }
        int startIndex = (index + 1) % arr.length;
        int prev = index;
        while(startIndex != index) {
        	if(arr[startIndex] != arr[prev]) {
        		count++;
                if (count >= k) {
                    groups++;
                }
        	} else {
                count = 1;
            }
        	prev = startIndex;
        	startIndex = (startIndex + 1) % arr.length;
        }
        return groups;
	}

	private int getLastRepeatingIndex(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                return i;
            }
        }
        if(arr[0] == arr[arr.length - 1]) {
            return 0;
        }
        return -1;
    }
}
