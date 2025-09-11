package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P128 {
	public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        Set<Integer> visited = new HashSet<>();
        int maxCount = 0;
        for(int num : set) {
            if(!visited.contains(num)) {
                visited.add(num);
                int count = 1;
                int currNum = num - 1;
                while(set.contains(currNum)) {
                    visited.add(currNum);
                    currNum--;
                    count++;
                }
                currNum = num + 1;
                while(set.contains(currNum)) {
                    visited.add(currNum);
                    currNum++;
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
