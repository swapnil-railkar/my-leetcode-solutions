package com.leetCode;


public class P48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] nums = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotateArray(nums);
	}

	private static void rotateArray(int[][] nums) {
		// TODO Auto-generated method stub
		
		int rows = nums.length;
		int col = nums[0].length;
		int[][] rotate = new int[rows][col];
		for(int i=0; i< col; i++) {
			int temp = rows-1;
			for(int j=0 ; j< rows; j++) {
				rotate[i][j] = nums[temp][i];
				temp--;
			}
		}
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<col ; j++) {
				nums[i][j] = rotate[i][j];
			}
		}
	}

}
