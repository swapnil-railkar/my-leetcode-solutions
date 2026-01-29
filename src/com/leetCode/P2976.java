package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P2976 {
	public long solution(String source, String target, char[] original, char[] changed, int[] cost) {
        Map<Character, List<Node>> graph = new HashMap<>();
        Map<Character, long[]> dp = new HashMap<>();
        int n = original.length;
        for(char ch : original) {
            graph.put(ch, new ArrayList<>());
        }

        for(int i = 0; i< n; i++) {
            graph.get(original[i]).add(new Node(changed[i], cost[i]));
        }
        
        long minCost = 0L;
        for(int i = 0; i< source.length(); i++) {
        	char s = source.charAt(i);
        	char t = target.charAt(i);
        	if(s != t) {
        		int targetIndex = t - 'a';
        		if(!dp.containsKey(s)) {
        			long[] paths = getShortestPaths(s, graph);
        			dp.put(s, paths);
        		}
        		long[] dist = dp.get(s);
                if(dist[targetIndex] == Long.MAX_VALUE) {
                    return -1L;
                }
    			minCost += dist[targetIndex];
        	}
        }
        return minCost;
    }

    private long[] getShortestPaths(char source, Map<Character, List<Node>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Long.compare(a.cost, b.cost));
        long[] dist = new long[26];
        Arrays.fill(dist, Long.MAX_VALUE);
        pq.add(new Node(source, 0));
        
        while(!pq.isEmpty()) {
        	Node curr = pq.poll();
        	char currVal = curr.value;
        	long currCost = curr.cost;
        	if(dist[currVal - 'a'] < currCost) {
        		continue;
        	}
        	for(Node next : graph.getOrDefault(currVal, new ArrayList<>())) {
        		char nextVal = next.value;
        		long nextCost = currCost + next.cost;
        		if(nextCost < dist[nextVal - 'a']) {
        			dist[nextVal - 'a'] = nextCost;
        			pq.add(new Node(nextVal, nextCost));
        		}
        	}
        }
        return dist;
    }

    private class Node {
        char value;
        long cost;
        Node(char value, long cost) {
            this.value = value;
            this.cost = cost;
        }
    }
}
