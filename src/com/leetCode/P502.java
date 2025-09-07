package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P502 {
	public int solution(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.profit, a.profit));
        for(int i = 0; i< profits.length; i++) {
            pq.add(new Project(capital[i], profits[i]));
        }
        int cap = w;
        while(!pq.isEmpty() && k > 0) {
            List<Project> res = new ArrayList<>();
            while(!pq.isEmpty() && pq.peek().capital > cap) {
                res.add(pq.poll());
            }
            if(pq.isEmpty()) {
                // no project can be done in current cap balance.
                return cap;
            }
            Project p = pq.poll();
            cap += p.profit;
            for(Project pr : res) {
                pq.add(pr);
            }
            k--;
        }
        return cap;
    }

    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }
}
