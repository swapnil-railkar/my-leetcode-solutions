package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P621 {
	public int solution(char[] tasks, int n) {
        Map<Character, Integer> taskFreqMap = new HashMap<>();
        for (char task : tasks) {
            int freq = taskFreqMap.getOrDefault(task, 0) + 1;
            taskFreqMap.put(task, freq);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (char key : taskFreqMap.keySet()) {
            pq.add(taskFreqMap.get(key));
        }

        int time = 0;
        while (!pq.isEmpty()) {
            List<Integer> rem = new ArrayList<>();
            int count = n + 1;
            // replace count by tasks.
            while(count > 0 && !pq.isEmpty()) {
                int curr = pq.poll();
                if(curr - 1 > 0) {
                    rem.add(curr - 1);
                }
                count--;
                time++;
            }
            // refill pq with remaining
            for(int r : rem) {
                pq.add(r);
            }

            // if tasks remain then cpu remain ideal for time of remaining count
            if(!pq.isEmpty()) {
                time += count;
            }
        }
        return time;
    }
}
