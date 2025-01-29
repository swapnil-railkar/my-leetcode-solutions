package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P684 {

	public int[] solution(int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();

		// init graph
		for(int[] row : edges) {
			// as graph is undirected, assume every edge is bi-directional
			populateGraph(graph, row[0], row[1]);

			// in rev direction
			populateGraph(graph, row[1], row[0]);
		}

		// nodes start from 1 so ignore 0th index
		boolean[] visited = new boolean[edges.length + 1];
		Set<Integer> loopedNodes = new HashSet<>();

		findLoopedNodes(graph, loopedNodes, 1, visited, 1);
		for(int  i= edges.length - 1; i>=0; i--) {
			if(loopedNodes.contains(edges[i][0]) && loopedNodes.contains(edges[i][1])) {
				return edges[i];
			}
		}
		return edges[0];
	}

	private void populateGraph(Map<Integer, Set<Integer>> graph, int key, int value) {
		if(graph.containsKey(key)) {
			graph.get(key).add(value);
		} else {
			Set<Integer> neigh = new HashSet<>();
			neigh.add(value);
			graph.put(key, neigh);
		}
	}

	private int findLoopedNodes(Map<Integer, Set<Integer>> graph, Set<Integer> loopedNodes, int key, boolean[] visited, int fromNode) {
		if(!graph.containsKey(key)) {
			visited[key] = true;
			return -1;
		} else {
			Set<Integer> neigh = graph.get(key);
			// mark node visited and explore neighbours
			visited[key] = true;
			for(int node: neigh) {
				if(node != fromNode) {
					if(visited[node]) {
						// loop found
						loopedNodes.add(node);
						return node;
					} else {
						int loopNode = findLoopedNodes(graph, loopedNodes, node, visited, key);
						if(loopNode != -1) {
							loopedNodes.add(node);
							if(loopNode == node) {
								// stop chain propogration
								return -1;
							} else {
								return loopNode;
							}
						}
					}
				}
			}

			return -1;
		}
	}
}
