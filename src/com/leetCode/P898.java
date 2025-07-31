package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P898 {
	public int solution(int[] arr) {
        Set<Integer> universal = new HashSet<>();
        Set<Integer> prev = new HashSet<>();
        prev.add(arr[arr.length - 1]);
        universal.add(arr[arr.length - 1]);
        for(int i = arr.length - 2; i >= 0; i--) {
            int num = arr[i];
            if (num == 0) {
                universal.add(0);
            } else {
                Set<Integer> curr = new HashSet<>();
                curr.add(num);
                universal.add(num);
                for(int or : prev) {
                    int currOR = num | or;
                    universal.add(currOR);
                    curr.add(currOR);
                }
                prev = curr;
            }
        }
        return universal.size();
    }
}
