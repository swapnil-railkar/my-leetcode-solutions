package com.leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P1353 {
	public int solution(int[][] events) {
		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = events.length;
        int day = 0, i = 0, attended = 0;

        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) {
                day = events[i][0];
            }

            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                attended++;
                day++;
            }
        }

        return attended;
    }
}
