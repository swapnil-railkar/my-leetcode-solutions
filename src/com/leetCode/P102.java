package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

import java.util.*;

public class P102 {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> levels = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        updateLevels(levels, level);
        return levels;
    }

    public void updateLevels(List<List<Integer>> levels, List<TreeNode> level) {
        if(level.isEmpty()) {
            return;
        }
        // add current level to levels and get next level.
        List<Integer> values = new ArrayList<>();
        List<TreeNode> nextLvl = new ArrayList<>();
        for(TreeNode node : level) {
            values.add(node.val);
            if(node.left != null) {
                nextLvl.add(node.left);
            }
            if(node.right != null) {
                nextLvl.add(node.right);
            }
        }
        levels.add(values);
        updateLevels(levels, nextLvl);
    }
}
