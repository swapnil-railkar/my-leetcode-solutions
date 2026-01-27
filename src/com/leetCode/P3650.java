package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class P3650 {
	public int solution(int n, int[][] edges) {
        List<List<Node>> graph = new ArrayList<>();
        List<List<Node>> rev = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new Node(v, w)); 
            rev.get(v).add(new Node(u, 2 * w)); 
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currVal = curr.value;
            int currCost = curr.cost;

            if (currCost > dist[currVal])
                continue;

            // Normal edges
            for (Node neigh : graph.get(currVal)) {
                int nextVal = neigh.value;
                int nextCost = currCost + neigh.cost;

                if (nextCost < dist[nextVal]) {
                    dist[nextVal] = nextCost;
                    pq.add(new Node(nextVal, nextCost)); 
                }
            }

            // Reversed edges (using switch at currVal)
            for (Node neigh : rev.get(currVal)) {
                int nextVal = neigh.value;
                int nextCost = currCost + neigh.cost;

                if (nextCost < dist[nextVal]) {
                    dist[nextVal] = nextCost;
                    pq.add(new Node(nextVal, nextCost));
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }

    private static class Node {
        int value, cost;

        Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }
}
