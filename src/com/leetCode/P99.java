package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

import java.util.Objects;
import java.util.Stack;

public class P99 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        validateBst(root);
    }
    private static void validateBst(TreeNode root) {
        if (root == null) {
            return;
        }

        if (!isLeaf(root)) {
            final Stack<TreeNode> leftStack = isPresent(root.left) ? validateLeftTree(root.left, root, new Stack<TreeNode>()) : null;
            final Stack<TreeNode> rightStack = isPresent(root.left) ? validateRightTree(root.right, root, new Stack<TreeNode>()) : null;
            final TreeNode inValidLeftValue = !leftStack.isEmpty() ? leftStack.pop() : null;
            final TreeNode inValidRightValue = !rightStack.isEmpty() ? rightStack.pop() : null;

            if (Objects.nonNull(inValidLeftValue) && Objects.nonNull(inValidRightValue)) {
                int temp = inValidLeftValue.val;
                inValidLeftValue.val = inValidRightValue.val;
                inValidRightValue.val = temp;
                return;
            }

            if (Objects.nonNull(inValidLeftValue)) {
                int temp = root.val;
                root.val = inValidLeftValue.val;
                inValidLeftValue.val = temp;
                return;
            }

            if (Objects.nonNull(inValidRightValue)) {
                int temp = root.val;
                root.val = inValidRightValue.val;
                inValidRightValue.val = temp;
                return;
            }
        }

        validateBst(root.left);
        validateBst(root.right);
    }

    private static Stack<TreeNode> validateLeftTree(TreeNode root, TreeNode currNode, Stack<TreeNode> stack) {
        if (root == null) {
            return stack;
        }

        if (root.val >= currNode.val) {
            stack.push(root);
        }

        return stack;
    }

    private static Stack<TreeNode> validateRightTree(TreeNode root, TreeNode currNode, Stack<TreeNode> stack) {
        if (root == null) {
            return stack;
        }

        if (root.val <= currNode.val) {
            stack.push(root);
        }

        return stack;
    }

    private static boolean isLeaf(TreeNode root) {
        return !isPresent(root.left) && !isPresent(root.right);
    }

    private static boolean isPresent(TreeNode node) {
        return node!=null;
    }
}
