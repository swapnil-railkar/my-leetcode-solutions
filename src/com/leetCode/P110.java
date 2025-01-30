package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

public class P110 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

    }

    private static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);
        int diff;
        if (leftHeight > rightHeight) {
            diff = leftHeight - rightHeight;
            return diff <= 1;
        } else if (rightHeight > leftHeight) {
            diff = rightHeight - leftHeight;
            return diff <= 1;
        } else if (leftHeight == rightHeight){
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
    private static int leftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(leftHeight(root.left), leftHeight(root.right)) + 1;
    }

    private static int rightHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(rightHeight(root.left), rightHeight(root.right)) + 1;
    }
}
