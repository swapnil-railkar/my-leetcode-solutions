package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P1865 {
	int[] nums1 = null;
    int[] nums2 = null;
    Map<Integer, Integer> nums1CountMap = new HashMap<>();
    Map<Integer, Integer> nums2CountMap = new HashMap<>();
    public P1865(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int n1 : nums1) {
            nums1CountMap.put(n1, nums1CountMap.getOrDefault(n1, 0) + 1);
        }
        for(int n2 : nums2) {
            nums2CountMap.put(n2, nums2CountMap.getOrDefault(n2, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        if(nums2CountMap.get(nums2[index]) - 1 == 0) {
            nums2CountMap.remove(nums2[index]);
        } else {
            nums2CountMap.put(nums2[index], nums2CountMap.get(nums2[index]) - 1);
        }
        nums2[index] = nums2[index] + val;
        nums2CountMap.put(nums2[index], nums2CountMap.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for(int num1 : nums1CountMap.keySet()) {
            int rem = tot - num1;
            if(nums2CountMap.containsKey(rem)) {
                count += nums1CountMap.get(num1) * nums2CountMap.get(rem);
            }
        }
        return count;
    }
}
