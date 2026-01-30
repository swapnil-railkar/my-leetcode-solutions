package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class P2977 {

	public long solution(String source, String target, String[] original, String[] changed, int[] cost) {
		Map<String, List<Node>> graph = new HashMap<>();
		Map<String, Map<String, Long>> allPairCost = new HashMap<>();
		Set<String> patterns = new HashSet<>();
		for(String str : original) {
			graph.put(str, new ArrayList<>());
		}

		for(int i =0; i< original.length; i++) {
			graph.get(original[i]).add(new Node(changed[i], cost[i]));
			patterns.add(original[i]);
			patterns.add(changed[i]);
		}

		for (String p : patterns) {
			allPairCost.put(p, getShortestPaths(p, graph));
		}

		Map<Integer, Set<String>> patternsByLen = new HashMap<>();
		for (String p : patterns) {
			patternsByLen.computeIfAbsent(p.length(), k -> new HashSet<>()).add(p);
		}

		int n = source.length();
		long[] dpArr = new long[n + 1];
		Arrays.fill(dpArr, Long.MAX_VALUE);
		dpArr[0] = 0;
		for (int i = 0; i < n; i++) {
			if (dpArr[i] == Long.MAX_VALUE) {
				continue;
			}

			// Always allow matching single characters if equal
			if (source.charAt(i) == target.charAt(i)) {
				dpArr[i + 1] = Math.min(dpArr[i + 1], dpArr[i]);
			}


			for (int len : patternsByLen.keySet()) {
				if (i + len > n) {
					continue;
				}

				String srcSub = source.substring(i, i + len);
				String tgtSub = target.substring(i, i + len);

				// Case 1: already equal
				if (srcSub.equals(tgtSub)) {
					dpArr[i + len] = Math.min(dpArr[i + len], dpArr[i]);
				}

				// Case 2: transform using rules
				if (allPairCost.containsKey(srcSub)) {
					Long c = allPairCost.get(srcSub).get(tgtSub);
					if (c != null) {
						dpArr[i + len] = Math.min(dpArr[i + len], dpArr[i] + c);
					}
				}
			}
		}

		return dpArr[n] == Long.MAX_VALUE ? -1 : dpArr[n];
	}

	private Map<String, Long> getShortestPaths(String source, Map<String, List<Node>> graph) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
		Map<String, Long> distMap = new HashMap<>();
		distMap.put(source, 0L);
		pq.add(new Node(source, 0));
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			String currVal = curr.value;
			long currCost = curr.cost;

			if(currCost > distMap.getOrDefault(currVal, Long.MAX_VALUE)) {
				continue;
			}
			for(Node neigh : graph.getOrDefault(currVal, new ArrayList<>())) {
				String val = neigh.value;
				long cost = currCost + neigh.cost;
				if(!distMap.containsKey(val) || cost < distMap.getOrDefault(val, Long.MAX_VALUE)) {
					distMap.put(val, cost);
					pq.add(new Node(val, cost));
				}
			}
		}
		return distMap;
	}

	private class Node {
		String value;
		long cost;
		Node(String value, long cost) {
			this.value = value;
			this.cost = cost;
		}
	}
}
