package com.leetCode;

public class P88 {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        for(int i = 0; i< m; i++) {
            temp[i] = nums1[i];
        }
        int index1 = 0;
        int index2 = 0;
        for(int i =0; i< nums1.length; i++) {
            if(index1 < m && index2 < n) {
                if(temp[index1] < nums2[index2]) {
                    nums1[i] = temp[index1];
                    index1++;
                } else {
                    nums1[i] = nums2[index2];
                    index2++;
                }
            } else if(index1 < m && index2 >= n) {
                nums1[i] = temp[index1];
                index1++;
            } else {
                nums1[i] = nums2[index2];
                index2++;
            }
        }
    }
}
