package com.leetCode;

import java.util.HashSet;
import java.util.Set;

public class P2965 {

	public int[] solution(int[][] grid) {
		int n = grid.length;
		int tot = n*n;
		Set<Integer> cache = new HashSet<>();
		int repeat = -1;
		int expectedSum = (tot * (tot + 1)) / 2;
        int actualSum = 0;
		
		for(int row= 0; row < n; row++) {
			for(int column = 0; column < n; column++) {
				if(cache.contains(grid[row][column])) {
					repeat = grid[row][column];
				} else {
					cache.add(grid[row][column]);
                    actualSum += grid[row][column];
				}
			}
		}

        if(expectedSum > actualSum) {
           return new int[] {repeat, (expectedSum - actualSum)}; 
        } else {
            return new int[] {repeat, (actualSum - expectedSum)}; 
        }
	}
}
