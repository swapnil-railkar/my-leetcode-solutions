package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class P2685 {

	public int solution(int n, int[][] edges) {
		boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Stack<Integer> stk = null;
        int count = 0;

        // init graph
        for (int i = 0; i < edges.length; i++) {
            updateGraph(graph, edges[i][0], edges[i][1]);
            updateGraph(graph, edges[i][1], edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (graph.containsKey(i)) {
                    stk = new Stack<>();
                    stk.push(i);
                    if(isCompleteGraph(stk, graph, visited, -1, new HashSet<>(), new HashSet<>())) {
                    	count++;
                    }
                } else {
                	count++;
                }
            }
        }

        return count;
	}

	private boolean isCompleteGraph(Stack<Integer> stk, Map<Integer, List<Integer>> graph, boolean[] visited, int from, Set<Set<Integer>> edges, Set<Integer> nodes) {
		if (stk.isEmpty()) {
			return edges.size() == (nodes.size() * (nodes.size() - 1)) / 2;
		}

		int node = stk.pop();
		nodes.add(node);
		visited[node] = true;
		List<Integer> neigh = graph.get(node);

		for(int n : neigh) {
			if(!visited[n] && n != from) {
				stk.push(n);
				Set<Integer> edge = new HashSet<>();
				edge.add(n);
	            edge.add(node);
				edges.add(edge);
			}
		}
		return isCompleteGraph(stk, graph, visited, node, edges, nodes);
	}
	
	private void updateGraph(Map<Integer, List<Integer>> graph, int key, int value) {
		if(graph.containsKey(key)) {
			graph.get(key).add(value);
		} else {
			List<Integer> list = new ArrayList<>();
			list.add(value);
			graph.put(key, list);
		}
	}
}
