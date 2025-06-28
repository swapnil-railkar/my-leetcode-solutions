package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P2099 {
	public int[] solution(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int num : nums) {
            pq.add(num);
        }
        List<Integer> kMax = new ArrayList<>();
        for(int i = 0 ;i< k; i++) {
            kMax.add(pq.remove());
        }
        int[] ans = new int[k];
        int index = 0;
        for(int i = 0; i< nums.length && index < k; i++) {
            if(contains(kMax, nums[i])) {
                ans[index] = nums[i];
                Integer num = new Integer(nums[i]);
                kMax.remove(num);
                index++;
            }
        }
        return ans;
    }

    private boolean contains(List<Integer> nums, int key) {
        int start = 0;
        int end = nums.size() - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums.get(mid) == key) {
                return true;
            } else if(nums.get(mid) > key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
