package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.leetCode.DsNodes.TreeNode;

public class P2196 {
	public TreeNode solution(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();
        for(int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;

            if(!nodeMap.keySet().contains(parent)) {
                nodeMap.put(parent, new TreeNode(parent));
            }

            if(!nodeMap.keySet().contains(child)) {
                nodeMap.put(child, new TreeNode(child));
            }

            if(isLeft) {
                nodeMap.get(parent).left = nodeMap.get(child);
            } else {
                nodeMap.get(parent).right = nodeMap.get(child);
            }
            childSet.add(child);
        }

        int root = -1;
        for(int key : nodeMap.keySet()) {
            if(!childSet.contains(key)) {
                root = key;
                break;
            }
        }
        return nodeMap.get(root);
    }
}
