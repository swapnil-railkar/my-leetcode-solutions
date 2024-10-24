package com.leetCode;

public class P1351 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[][] grid = {{3,2},{1,0}};
       int nums = getNegNums(grid);
       System.out.println(nums);
	}

	private static int getNegNums(int[][] grid) {
		// TODO Auto-generated method stub
		int count =0;
		
		for(int i= 0; i< grid.length; i++) {
			for(int j=grid[0].length-1 ; j>=0; j--) {
				if(grid[i][j] < 0) {
					count++;
				}else {
					break;
				}
			}
		}
		return count;
	}

}
