package com.leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P2402 {
	public int solution(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((a, b) -> {
            if (a.freeAt == b.freeAt) {
                return Integer.compare(a.room, b.room);
            }
            return Long.compare(a.freeAt, b.freeAt);
        });
        PriorityQueue<Integer> roomQ = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            roomQ.add(i);
        }
        int[] count = new int[n];

        for (int[] meet : meetings) {
            while (!pq.isEmpty() && pq.peek().freeAt <= meet[0]) {
                Wrapper w = pq.poll();
                roomQ.add(w.room);
            }

            if(!roomQ.isEmpty()) {
                int room = roomQ.poll();
                pq.add(new Wrapper(room, meet[1]));
                count[room] += 1;
            } else {
                Wrapper w = pq.poll();
                int room = w.room;
                pq.add(new Wrapper(room,  w.freeAt + (meet[1] - meet[0])));
                count[room] += 1;
            }
        }

        int maxCountRoom = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxCountRoom = i;
            }
        }

        return maxCountRoom;
    }

    private static class Wrapper {
        int room;
        long freeAt;

        Wrapper(int room, long freeAt) {
            this.room = room;
            this.freeAt = freeAt;
        }
    }
}
