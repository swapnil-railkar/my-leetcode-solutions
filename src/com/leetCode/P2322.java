package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P2322 {
    int minScore = Integer.MAX_VALUE;

    public int minimumScore(int[] nodeValues, int[][] edges) {
        int n = nodeValues.length;

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int totalXor = 0;
        for (int value : nodeValues) {
            totalXor ^= value;
        }
        dfs(0, -1, nodeValues, adjList, totalXor);

        return minScore;
    }

    private int calculateScore(int xor1, int xor2, int xor3) {
        return (
            Math.max(xor1, Math.max(xor2, xor3)) - 
            Math.min(xor1, Math.min(xor2, xor3))
        );
    }

    // DFS function to traverse the tree and compute XOR for each component
    private int dfs(int currentNode, int parentNode, int[] nodeValues, List<List<Integer>> adjList, int totalXor) {
        int componentXor = nodeValues[currentNode];

        for (int neighbor : adjList.get(currentNode)) {
            if (neighbor == parentNode) {
                continue;
            }
            componentXor ^= dfs(neighbor, currentNode, nodeValues, adjList, totalXor);
        }

        // After calculating the subtree XOR, we try to remove edges and split the tree into 3 components
        for (int neighbor : adjList.get(currentNode)) {
            if (neighbor == parentNode) {
                dfs2(neighbor, currentNode, componentXor, currentNode, nodeValues, adjList, totalXor);
            }
        }

        return componentXor;
    }

  
    private int dfs2(
    	int currentNode, 
        int parentNode,  
        int currentComponentXor,
        int ancestorNode,
        int[] nodeValues,
        List<List<Integer>> adjList,
        int totalXor
    ) {
        int componentXor = nodeValues[currentNode]; 

        for (int neighbor : adjList.get(currentNode)) {
            if (neighbor == parentNode) {
                continue;
            }
            componentXor ^= dfs2(neighbor, currentNode, currentComponentXor, ancestorNode, nodeValues, adjList, totalXor);
        }

        if (parentNode == ancestorNode) {
            return componentXor;
        }

        minScore = Math.min(minScore, calculateScore(currentComponentXor, componentXor, totalXor ^ currentComponentXor ^ componentXor));

        return componentXor;
    }
}
