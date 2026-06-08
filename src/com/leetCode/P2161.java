package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P2161 {
	public int[] solution(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int count = 0;
        for(int num : nums) {
            if(num < pivot) {
                smaller.add(num);
            } else if(num > pivot) {
                greater.add(num);
            } else {
                count++;
            }
        }
        int index = 0;
        for(int num : smaller) {
            nums[index] = num;
            index++;
        }
        while(count > 0) {
            nums[index] = pivot;
            index++;
            count--;
        }
        for(int num : greater) {
            nums[index] = num;
            index++;
        }
        return nums;
    }
}
