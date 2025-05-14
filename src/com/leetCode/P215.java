package com.leetCode;

import java.util.PriorityQueue;

public class P215 {
	public int solution(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for(int num : nums) {
            pq.add(num);
        }
        int max = -1;
        for(int i =0; i< k; i++) {
            max = pq.remove();
        }
        return max;
    }
}
