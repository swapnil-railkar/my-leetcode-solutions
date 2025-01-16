package com.leetCode;

public class P2425 {

	public int solution(int[] nums1, int[] nums2) {
		if ((nums1.length % 2 == 0) && (nums2.length % 2 == 0)) {
            return 0;
        } else {
            int nums2xor = getXorForArray(nums2);
            if (nums2.length % 2 == 0) {
                return nums2xor;
            } else {
                int nums1xor = getXorForArray(nums1);
                if (nums1.length % 2 == 0) {
                    return nums1xor;
                } else {
                    return (nums1xor ^ nums2xor);
                }
            }
        }
	}
	
	private int getXorForArray(int[] num) {
        int xor = 0;
        for (int n : num) {
            xor = xor ^ n;
        }
        return xor;
    }
}
