package com.leetCode;

import java.util.HashSet;
import java.util.Set;

import com.leetCode.DsNodes.TreeNode;

public class P1261 {

    private Set<Integer> nodes = new HashSet<>();

    public P1261(TreeNode root) {
        populateTree(root, 0);
    }
    
    public boolean find(int target) {
        return nodes.contains(target);
    }

    private void populateTree(TreeNode root, int value) {
        if(root == null) {
            return;
        } else {
            nodes.add(value);
        }
        populateTree(root.left, (value * 2) + 1);
        populateTree(root.right, (value * 2) + 2);
    }
}
