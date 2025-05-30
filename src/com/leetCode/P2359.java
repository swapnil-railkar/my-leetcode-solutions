package com.leetCode;

import java.util.Arrays;

public class P2359 {
	public int solution(int[] edges, int node1, int node2) {
        int[] node1Dist = new int[edges.length];
        int[] node2Dist = new int[edges.length];
        Arrays.fill(node1Dist, Integer.MAX_VALUE);
        Arrays.fill(node2Dist, Integer.MAX_VALUE);

        int dist = 0;
        while(node1 != -1 && node1Dist[node1] == Integer.MAX_VALUE) {
            node1Dist[node1] = dist++;
            node1 = edges[node1];
        }
    
        dist = 0;
        while(node2 != -1 && node2Dist[node2] == Integer.MAX_VALUE) {
            node2Dist[node2] = dist++;
            node2 = edges[node2];
        }

        int minNode = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i =0; i< edges.length; i++) {
            if(node1Dist[i] != Integer.MAX_VALUE && node2Dist[i] != Integer.MAX_VALUE) {
                int maxDist = Math.max(node1Dist[i], node2Dist[i]);
                if(maxDist < minDist) {
                    minDist = maxDist;
                    minNode = i;
                }
            }
        }
        return minNode;
    }
}
