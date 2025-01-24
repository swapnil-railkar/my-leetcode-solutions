package com.leetCode;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;

public class P802 {

	public List<Integer> solution(int[][] graph) {
        Set<Integer> pathToTerminal = new TreeSet<>();
    	int[] visited = new int[graph.length];
    	for(int i = graph.length - 1; i >=0; i--) {
    		if(!pathToTerminal.contains(i)) {
    			boolean canAddNode = visit(graph, i, visited, pathToTerminal);
                visited[i] = 1;
    			if(canAddNode) {
    				pathToTerminal.add(i);
    			}
    		}
    	}
    	return new ArrayList<>(pathToTerminal);
    }

    // create function that visits all nodes at given index and return true if it is safe node
    private boolean visit(int[][] graph, int index, int[] visited, Set<Integer> pathToTerminal) {
    	int[] neigh = graph[index];
    	if(neigh.length == 0) {
    		// node at index is terminal node as no outgoing paths
    		visited[index] = 1;
    		pathToTerminal.add(index);
    		return true;
    	}
    	for(int i = neigh.length - 1; i >=0; i--) {
    		int node = neigh[i];
            if(node == index) {
                // self loop detected
                return false;
            }
    		if(visited[node] == 1) {
    			if(!pathToTerminal.contains(node)) {
                    // node is visited but not part of path ToTerminal
                    return false;
                }
    		} else {
    			visited[node] = 1;
    			boolean canAddNode = visit(graph, node, visited, pathToTerminal);
    			if(canAddNode) {
    				pathToTerminal.add(node);
    			} else {
    				return false;
    			}
    		}
    	}
        return true;
    }
}