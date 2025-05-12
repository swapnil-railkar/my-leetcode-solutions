package com.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class P98 {
	
    public boolean solution(TreeNode root, Boolean isValid) {
    	return getSubtree(root) != null;

    }

    private List<Integer> getSubtree(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        } else if(root.left == null && root.right == null) {
            List<Integer> nodes = new ArrayList<>();
            nodes.add(root.val);
            return nodes;
        } else {
            List<Integer> leftNodes = getSubtree(root.left);
            List<Integer> rightNodes = getSubtree(root.right);
            if(leftNodes == null || rightNodes == null) {
                // invalid tree found.
                return null;
            }
            // validate current root.
            for(int node : leftNodes) {
                if(node >= root.val) {
                    // invalid node found.
                    return null;
                }
            }
            for(int node : rightNodes) {
                if(node <= root.val) {
                    // invalid node found.
                    return null;
                }
            }
            // node is valid return combination.
            List<Integer> combination = new ArrayList<>();
            combination.addAll(leftNodes);
            combination.addAll(rightNodes);
            combination.add(root.val);
            return combination;
        }
        
    }
}
