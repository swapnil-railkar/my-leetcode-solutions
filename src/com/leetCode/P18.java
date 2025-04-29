package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P18 {

	public List<List<Integer>> solution(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        for(int i =0; i< nums.length; i++) {
            for(int j = i + 1; j< nums.length; j++) {
                for(int k = j+1; k< nums.length; k++) {
                    long sum = (long) nums[i] + nums[j] + nums[k];
                    long rem = (long) target - sum;
                    int remIndex = findIndex(rem, 0, nums.length - 1, nums);
                    if(remIndex != -1 && remIndex != i && remIndex != j && remIndex != k) {
                        List<Integer> subset = new ArrayList<>(Arrays.asList((int) rem, nums[i], nums[j], nums[k]));
                        Collections.sort(subset);
                        if(!subsets.contains(subset)) {
                            subsets.add(subset);
                        }
                    }
                }
            }
        }
        return subsets;
    }

    private int findIndex(long key, int start, int end, int[] nums) {
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == key) {
                return mid;
            } else if(nums[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
