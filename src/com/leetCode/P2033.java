package com.leetCode;

import java.util.Arrays;

public class P2033 {

	public int solution(int[][] grid, int num) {
		int rows = grid.length;
		int columns = grid[0].length;
		int[] arr = new int[rows * columns];
        if(arr.length == 1) {
            return 0;
        }
		int index = 0;
		int rem = grid[0][0] % num;
		for(int row = 0; row < rows; row++) {
			for(int column = 0; column < columns; column++) {
				arr[index] = grid[row][column];
				if(arr[index] % num != rem) {
					return -1;
				}
				index++;
			}
		}
		
		Arrays.sort(arr);
		int count = 0;
		int median = arr[arr.length / 2];
		for(int i = 0; i< arr.length; i++) {
			count += ((Math.max(arr[i], median) - Math.min(arr[i], median)) / num);
		}
		return count;
	}

}
