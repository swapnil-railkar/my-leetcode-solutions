package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

import java.util.*;

public class P101_2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(2);

        TreeNode lr = new TreeNode(3);
        TreeNode rr = new TreeNode(3);

        root.left = l;
        root.right = r;
        l.right = lr;
        r.right = rr;

        if (isLeaf(root)) {
            System.out.println(true);
        }

        if (eligible(root)) {
            // Entry for node 26 is missing but for 76 is available
            System.out.println(compareNodes(root.left, root.right));
        } else {
            System.out.println(false);
        }
    }

    private static boolean compareNodes(TreeNode leftRoot, TreeNode rightRoot) {

        if (leftRoot == null && rightRoot == null) {
            return true;
        }

        if ((leftRoot!= null && rightRoot == null) || (leftRoot == null && rightRoot != null)) {
            return false;
        }

        if ((isLeaf(leftRoot) && !isLeaf(rightRoot)) || (!isLeaf(leftRoot) && isLeaf(rightRoot))){
            return false;
        }

        if (!Objects.equals(leftRoot.val, rightRoot.val)) {
            return false;
        }

        return compareNodes(leftRoot.left, rightRoot.right)
                && compareNodes(leftRoot.right, rightRoot.left);
    }
    private static boolean isLeaf(final TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static boolean eligible(TreeNode node) {
        return (node.left != null && node.right != null) && (node.left.val == node.right.val);
    }

}
