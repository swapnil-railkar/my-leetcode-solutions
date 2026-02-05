package com.leetCode;

import java.util.PriorityQueue;

public class P1792 {
	public double solution(int[][] classes, int extraStudents) {
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((a, b) -> Double.compare(b.gain, a.gain));
        for(int[] c: classes) {
            pq.add(new Wrapper(c[0], c[1]));
        }
        for(int i = 0; i< extraStudents; i++) {
            Wrapper w = pq.poll();
            int pass = w.pass;
            int total = w.total;
            pq.add(new Wrapper(pass + 1, total + 1));
        }
        double avgPass = 0.0;
        while(!pq.isEmpty()) {
            Wrapper w = pq.poll();
            avgPass += ((double) w.pass / w.total);
        }
        return avgPass/ classes.length;
    }

    private class Wrapper{
        int pass, total;
        double gain;
        Wrapper(int pass, int total) {
            this.pass = pass;
            this.total = total;
            this.gain = ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
        }
    }
}
