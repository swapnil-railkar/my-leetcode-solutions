package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P2493 {

	public int solution(int nodes, int[][] edges) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for(int[] edge : edges) {
			populateGraph(graph, edge[0], edge[1]);
			populateGraph(graph, edge[1], edge[0]);
		}

		List<Wrapper> list = new ArrayList<>();
		for(int i = 1; i<= nodes; i++) {
			Set<Integer> nodesUsed = new HashSet<>();
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[nodes + 1];
			int[] levels = new int[nodes + 1];
			q.add(i);
			levels[i] = 1;
			nodesUsed.add(i);
			int maxForIndex = getMaxLevel(graph, q, visited, levels, nodesUsed,1);
			if(maxForIndex == -1) {
				return -1;
			} else {
				updateList(list, maxForIndex, nodesUsed);
			}
		}
		return getSum(list);
	}

	private int getSum(List<Wrapper> list) {
		int sum = 0;
		for(Wrapper obj: list) {
			sum += obj.level;
		}
		return sum;
	}

	private void updateList(List<Wrapper> list, int maxForIndex, Set<Integer> nodesUsed) {
		for(Wrapper obj : list) {
			if(!Collections.disjoint(obj.nodes, nodesUsed)) {
				obj.level = Math.max(maxForIndex, obj.level);
				return;
			}
		}
		// new entry found
		Wrapper wrapper = new Wrapper(nodesUsed, maxForIndex);
		list.add(wrapper);

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

	private int getMaxLevel(Map<Integer, Set<Integer>> graph, Queue<Integer> q, boolean[] visited,
			int[] levels, Set<Integer> nodesUsed,int maxValue) {
		if(q.isEmpty()) {
			return maxValue;
		} else {
			// explore node key
			int key = q.remove();
			visited[key] = true;
			nodesUsed.add(key);
			if(!graph.containsKey(key)) {
				getMaxLevel(graph, q, visited, levels, nodesUsed, maxValue);
			} else {
				Set<Integer> neigh = graph.get(key);
				int next = maxValue;
				// add neightbors to queue
				for(int node : neigh) {
					nodesUsed.add(node);
					if(!visited[node]) {
						if(levels[node] != 0) {
							int l1 = levels[node];
							int l2 = levels[key];
							if(Math.abs(l1 - l2) != 1) {
								// against rule
								return -1;
							}
						} else {
							levels[node] = levels[key] + 1;
							next = levels[node];
							q.add(node);
						}
					}
				}

				return getMaxLevel(graph, q, visited, levels, nodesUsed,next);
			}
			return maxValue;
		}
	}

	private static class Wrapper {
		Set<Integer> nodes;
		int level;

		Wrapper(Set<Integer> nodes, int level) {
			this.nodes = nodes;
			this.level = level;
		}
	}

}

