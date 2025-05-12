package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

public class P235 {
	
	public TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        return getLCA(root, p.val, q.val);
    }

    private TreeNode getLCA(TreeNode root, int key1, int key2) {
        if (root == null) {
            return null;
        }
        TreeNode leftVal = getLCA(root.left, key1, key2);
        TreeNode rightVal = getLCA(root.right, key1, key2);
        if (leftVal == null && rightVal == null) {
            if (key1 == root.val || key2 == root.val) {
                return root;
            }
            return null;
        } else if (leftVal != null && rightVal != null) {
            return root;
        } else {
            if (leftVal != null && rightVal == null) {
                if (key1 == root.val || key2 == root.val) {
                    return root;
                }
                return leftVal;
            }
            if (key1 == root.val || key2 == root.val) {
                return root;
            }
            return rightVal;
        }
    }
}
