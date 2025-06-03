package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P57 {

    public int[][] solution(int[][] intervals, int[] newInterval) {
    	List<int[]> mergedIntervals = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.add(newInterval);
        for(int[] interval : intervals) {
            pq.add(interval);
        }
        int[] currInterval = pq.remove();
        while(!pq.isEmpty()) {
            int[] interval = pq.remove();
            if(currInterval[1] < interval[0]) {
                mergedIntervals.add(currInterval);
            } else {
                interval[0] = Math.min(currInterval[0], interval[0]);
                interval[1] = Math.max(currInterval[1], interval[1]);
            }
            currInterval = interval;
        }
        mergedIntervals.add(currInterval);
        return convertToArray(mergedIntervals);
    }
    
    private int[][] convertToArray(List<int[]> mergedIntervals) {
        int[][] matrix = new int[mergedIntervals.size()][2];
        for(int i = 0; i< mergedIntervals.size(); i++) {
            matrix[i][0] = mergedIntervals.get(i)[0];
            matrix[i][1] = mergedIntervals.get(i)[1];
        }
        return matrix;
    }
}
