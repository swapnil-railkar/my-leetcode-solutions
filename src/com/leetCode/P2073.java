package com.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class P2073 {
	public int solution(int[] tickets, int k) {
        Queue<Wrapper> q = new LinkedList<>();
        for(int i = 0; i< tickets.length; i++) {
            q.add(new Wrapper(tickets[i], i == k));
        }
        int time = 0;
        while(!q.isEmpty()) {
            time++;
            Wrapper w = q.remove();
            int ticket = w.count - 1;
            if(ticket > 0) {
                w.count = ticket;
                q.add(w);
            } else {
                // ticket == 0
                if(w.isTarget) {
                    break;
                }
            }
        }
        return time;
    }

    private class Wrapper {
        int count;
        boolean isTarget;
        Wrapper(int count, boolean isTarget) {
            this.count = count;
            this.isTarget = isTarget;
        }
    }
}
