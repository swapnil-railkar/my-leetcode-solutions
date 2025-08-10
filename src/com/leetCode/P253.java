package com.leetCode;

import java.util.List;
import java.util.PriorityQueue;

public class P253 {
	public int solution(List<int[]> intervals) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for(int[] interval : intervals) {
            pq.add(interval);
        }
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int start = curr[0];
            int end = curr[1];
            if(!rooms.isEmpty() && rooms.peek() <= start) {
                rooms.poll();
            }
            rooms.add(end);
        }
        return rooms.size();
    }
}
