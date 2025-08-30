package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class P264 {
	public int solution(int n) {
		Map<Integer, Long> numIndexMap = new HashMap<>();
        Set<Long> nums = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        int index = 1;
        while(nums.size() < n && !pq.isEmpty()) {
            long num = pq.poll();
            if(!nums.contains(num)) {
                nums.add(num);
                numIndexMap.put(index, num);
                index++;
                if(!nums.contains(num * 2)) {
                    pq.add(num * 2);
                }
                if(!nums.contains(num * 3)) {
                    pq.add(num * 3);
                }
                if(!nums.contains(num * 5)) {
                    pq.add(num * 5);
                }
            }
        }
        return numIndexMap.get(n).intValue();
    }
}
