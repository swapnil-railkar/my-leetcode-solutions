package com.leetCode.Graph;

import java.util.*;

public class P207 {

    public static void main(String[] args) {
        int[][] prerequisites = {
                {1,0}
        }; // true
        System.out.println(canFinish(prerequisites));
    }

    private static boolean canFinish(int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> allNodes = new HashSet<>();
        for (int[] prerequisite : prerequisites) {
            Integer key = prerequisite[0];
            Integer value = prerequisite[1];
            allNodes.add(key);
            allNodes.add(value);

            if (key.equals(value)) {
                // self loop
                return false;
            }

            // New pair detected, populate graph
            List<Integer> values = map.get(key);
            if (values == null || values.isEmpty()) {
                values = new ArrayList<>();
            }
            values.add(value);
            map.put(key, values);

        }

        return !checkNodes(allNodes, map);
    }

    private static boolean checkNodes(Set<Integer> allNodes, Map<Integer, List<Integer>> map) {
        Set<Integer> whiteSet = allNodes;
        Set<Integer> greySet = new HashSet<>();
        Set<Integer> blackSet = new HashSet<>();

        while (whiteSet.size() > 0) {
            Integer node = whiteSet.iterator().next();
            if (!map.containsKey(node)) {
                swapSet(node, whiteSet, blackSet);
                continue;
            }
            if (cycleDetected(node, map, whiteSet, greySet, blackSet)) {
                return true;
            }
        }
        return false;
    }

    // True -> cycle
    // false -> no cycle
    // This approach is from : https://youtu.be/rKQaZuoUR4M?si=XtxFZAeuKA1-_SLj  (3 set approach to find cycle in directed graph)
    private static boolean cycleDetected(Integer key, Map<Integer, List<Integer>> map, Set<Integer> whiteSet, Set<Integer> greySet, Set<Integer> blackSet) {

        swapSet(key, whiteSet, greySet);

        for(Integer neigh : map.get(key)) {
            if (greySet.contains(neigh)) {
                return true;
            }

            if (blackSet.contains(neigh)) {
                continue;
            }

            if (!map.containsKey(neigh)) {
                swapSet(neigh, whiteSet, blackSet);
                return cycleDetected(key, map, whiteSet, greySet, blackSet);
            }

            if (cycleDetected(neigh, map, whiteSet, greySet, blackSet)) {
                return true;
            }
        }

        swapSet(key, greySet, blackSet);
        return false;
    }

    private static void swapSet(Integer value, Set<Integer> fromSet, Set<Integer> toSet) {
        fromSet.remove(value);
        toSet.add(value);
    }
}
