package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

public class P98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(32);
        TreeNode l = new TreeNode(26);
        TreeNode r = new TreeNode(47);
        TreeNode ll = new TreeNode(19);
        TreeNode rr = new TreeNode(56);
        TreeNode llr = new TreeNode(27);

        root.left = l;
        root.right = r;
        l.left = ll;
        r.right = rr;
        ll.right = llr;

        System.out.println(validateBst(root, false));
    }

    private static boolean validateBst(TreeNode root, Boolean isValid) {
        if (root == null) {
            return isValid;
        }

        if (!isLeaf(root)) {
            final Boolean validLeftValue = isPresent(root.left) ? validateLeftTree(root.left, root) : true;
            final Boolean validRightValue = isPresent(root.right) ? validateRightTree(root.right, root) : true;

            isValid =  validLeftValue && validRightValue;
            if (!isValid) {
                return false;
            }
        }

        return validateBst(root.left, isValid) && validateBst(root.right, isValid);

    }

    private static boolean validateLeftTree(TreeNode root, TreeNode currNode) {
        if (root == null) {
            return true;
        }

        if (root.val >= currNode.val) {
            return false;
        }

        return validateLeftTree(root.left, currNode) && validateLeftTree(root.right, currNode);
    }

    private static boolean validateRightTree(TreeNode root, TreeNode currNode) {
        if (root == null) {
            return true;
        }

        if (root.val <= currNode.val) {
            return false;
        }

        return validateRightTree(root.left, currNode) && validateRightTree(root.right, currNode);
    }

    private static boolean isLeaf(TreeNode root) {
        return !isPresent(root.left) && !isPresent(root.right);
    }

    private static boolean isPresent(TreeNode node) {
        return node!=null;
    }
}
