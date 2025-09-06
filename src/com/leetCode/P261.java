package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P261 {
	public boolean solution(int n, int[][] edges) {
        if(edges.length != n-1) {
            return false;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for(int i =0; i< n; i++) {
            graph.put(i, new HashSet<>());
        }

        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if(cycleFound(visited, 0, -1, graph)) {
            return false;
        }
        
        return true;
    }

    private boolean cycleFound(Set<Integer> visited, int node, int parent, Map<Integer, Set<Integer>> graph) {
        visited.add(node);
        for(int neigh : graph.get(node)) {
            if(neigh != parent) {
                if(visited.contains(neigh)) {
                    return true;
                }
                if(cycleFound(visited, neigh, node, graph)) {
                    return true;
                }
            }
        }
        return false;
    }
}
