package com.leetCode;

import java.util.*;

public class P207 {

	public boolean solution(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i< numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] req : prerequisites) {
            graph.get(req[0]).add(req[1]);
        }
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i< numCourses; i++) {
            if(!canComplete(graph, i, visiting, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean canComplete(Map<Integer, List<Integer>> graph, int node, Set<Integer> visiting, Set<Integer> visited) {
        if(visiting.contains(node)) {
            return false;
        } else if(visited.contains(node)) {
            return true;
        } else {
            List<Integer> neigh = graph.get(node);
            visiting.add(node);
            for(int n : neigh) {
                if(!canComplete(graph, n, visiting, visited)) {
                    return false;
                }
            }
            visiting.remove(node);
            visited.add(node);
            return true;
        }
    }
}
