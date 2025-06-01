package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

public class P112 {
	public boolean hasPathSum(TreeNode root, int targetSum) {
        return getAllPathSum(root, targetSum);
    }

    private boolean getAllPathSum(TreeNode root, int remSum) {
        if(root == null) {
            return false;
        } else if(root.left == null && root.right == null) {
           return remSum - root.val == 0; 
        } else {
            remSum -= root.val;
            return getAllPathSum(root.left, remSum) || getAllPathSum(root.right, remSum);
        }
    }
}
