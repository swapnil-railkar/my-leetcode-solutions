package com.leetCode;

import java.util.PriorityQueue;

public class P1354 {
	public boolean solution(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        long sum = 0;

        for (int num : target) {
            pq.add(num);
            sum += num;
        }

        while (true) {
            int max = pq.poll();
            long rest = sum - max;

            // If all elements are 1
            if (max == 1 || rest == 1)
                return true;

            // Impossible cases
            if (rest == 0 || max <= rest)
                return false;

            int prev = (int) (max % rest);
            if (prev == 0)
                return false;

            pq.add(prev);
            sum = rest + prev;
        }
    }
}
