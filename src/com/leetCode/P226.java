package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

public class P226 {
	public TreeNode solution(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode inverted = new TreeNode(root.val);
        inverted.left = solution(root.right);
        inverted.right = solution(root.left);
        return inverted;
    }
}
