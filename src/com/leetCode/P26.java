package com.leetCode;

public class P26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] nums= {0,0,1,1,1,2,2,3,3,4};
        int og = countOg(nums);
        System.out.println(og);
        
	}

	private static int countOg(int[] nums) {
		// TODO Auto-generated method stub
		int k = 0;
		
		for(int i=1; i< nums.length;i++) {
			if(nums[i] != nums[i-1]) {
				nums[k] = nums[i];
				k++;
			}
		}
		return k;
	}

}
