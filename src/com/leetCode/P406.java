package com.leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P406 {
	public int[][] solution(int[][] people) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        }); 

        for(int[] p : people) {
            pq.add(p);
        }
        int[][] q = new int[people.length][2];
        for(int[] sq : q) {
            Arrays.fill(sq, -1);
        }
        q[0] = pq.poll();
        fillQ(q, pq);
        return q;
    }

    private void fillQ(int[][] q, PriorityQueue<int[]> pq) {
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int count = 0;
            int index = 0;
            while(count <= curr[1]) {
                if(q[index][0] == -1) {
                    // unassigned slot.
                    break;
                } else if(q[index][0] >= curr[0]) {
                    count++;
                    if(count > curr[1]) {
                    	break;
                    }
                }
                index++;
            }

            if(q[index][0] == -1) {
                q[index] = curr;
            } else {
                for(int j = q.length - 2; j> index; j--) {
                    q[j+1] = q[j];
                }
                q[index] = curr;
            }
        }
    }
}
