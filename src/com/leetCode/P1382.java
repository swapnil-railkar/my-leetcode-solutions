package com.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class P1382 {
	public TreeNode solution(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        fillValues(values,root);
        return buildTree(values, 0, values.size() - 1);
    }

    private void fillValues(List<Integer> values, TreeNode node) {
        if(node != null) {
            fillValues(values, node.left);
            values.add(node.val);
            fillValues(values, node.right);
        }
    }

    private TreeNode buildTree(List<Integer> values, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = buildTree(values, start, mid - 1);
        node.right = buildTree(values, mid + 1, end);
        return node;
    }
}
