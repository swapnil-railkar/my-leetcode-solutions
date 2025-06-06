package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

public class P236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        } else if(root.val == p.val || root.val == q.val) {
            return root.val == p.val ? p : q;
        } else {
            TreeNode leftVal = lowestCommonAncestor(root.left, p, q);
            TreeNode rightVal = lowestCommonAncestor(root.right, p, q);
            if(leftVal != null && rightVal != null) {
                return root;
            }
            if(leftVal != null || rightVal != null) {
                return leftVal != null ? leftVal : rightVal;
            }
            return null;
        }
    }
}
