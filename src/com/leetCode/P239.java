package com.leetCode;

import java.util.PriorityQueue;

public class P239 {
	public int[] solution(int[] nums, int k) {
        int n = nums.length;
        int[] windows = new int[n - k + 1];
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));
        // init
        for(int i = 0; i< k; i++) {
            pq.add(new Wrapper(i, nums[i]));
        }
        windows[0] = pq.peek().val;
        int index = 1;
        for(int j = k; j< n; j++) {
            int exitIndex = j - k;
            pq.add(new Wrapper(j, nums[j]));
            while(!pq.isEmpty() && pq.peek().index <= exitIndex) {
                pq.poll();
            }
            windows[index] = pq.peek().val;
            index++;
        }
        return windows;
    }

    private static class Wrapper {
        int index;
        int val;
        Wrapper(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
}
