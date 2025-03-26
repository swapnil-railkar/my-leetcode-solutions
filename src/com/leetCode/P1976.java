package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P1976 {

	public int solution(int n, int[][] roads) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		int[][] cost = new int[roads.length][roads.length];
		// init graph
		for (int i = 0; i < roads.length; i++) {
			updateGraph(graph, roads[i][0], roads[i][1]);
			updateGraph(graph, roads[i][1], roads[i][0]);
			int row = Math.min(roads[i][0], roads[i][1]);
			int column = Math.max(roads[i][0], roads[i][1]);
			cost[row][column] = roads[i][2];
		}

		return dfs(graph, new HashMap<>(), n - 1, cost, 0, 0);
	}

	private int dfs(Map<Integer, List<Integer>> graph, Map<Integer, Integer> pathCountMap,
			int destination, int[][] cost, int node, int count) {
		if(node == destination) {
			return count;
		} else {
			List<Integer> neigh = graph.get(node);

			for(int n : neigh) {
				int row = Math.min(n , node);
				int column = Math.max(n , node);
				int pathCost = cost[row][column];
				int totCost = dfs(graph, pathCountMap, destination, cost, n, count + pathCost);
				if(pathCountMap.containsKey(totCost)) {
					pathCountMap.put(count, pathCountMap.get(totCost) + 1);
				} else {
					pathCountMap.put(totCost, 1);
				}
			}
			return getMinPathsTotal(pathCountMap);
		}
	}

	private int getMinPathsTotal(final Map<Integer, Integer> mp) {
		int minKey = Integer.MAX_VALUE;
		Set<Integer> keys = mp.keySet();
		int minWays = -1;
		for(int key : keys) {
			if(key < minKey) {
				minKey = key;
				minWays = mp.get(key);
			}
		}
		return minWays;
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
