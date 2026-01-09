package com.leetCode;

import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;

import com.leetCode.DsNodes.TreeNode;

public class P865 {
	public TreeNode solution(TreeNode root) {
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.height, a.height));
        getNodeHeights(root, 1, pq);
        if(pq.size() == 1) {
            return root;
        }
        int maxHeight = pq.peek().height;
        Set<Integer> maxHeightKeys = new HashSet<>();
        while(!pq.isEmpty() && pq.peek().height == maxHeight) {
            Wrapper w = pq.poll();
            maxHeightKeys.add(w.key);
        }
        return getCommonAncestor(root, maxHeightKeys);
    }

    private void getNodeHeights(TreeNode node, int height, PriorityQueue<Wrapper> pq) {
        if(node == null) {
            return;
        }
        pq.add(new Wrapper(node.val, height));
        getNodeHeights(node.left, height + 1, pq);
        getNodeHeights(node.right, height + 1, pq);
    }

    private TreeNode getCommonAncestor(TreeNode node, Set<Integer> maxHeightKeys) {
        if(node == null) {
            return null;
        }
        if(maxHeightKeys.contains(node.val)) {
            return node;
        }
        TreeNode leftVal = getCommonAncestor(node.left, maxHeightKeys);
        TreeNode rightVal = getCommonAncestor(node.right, maxHeightKeys);
        if(Objects.nonNull(leftVal) && Objects.nonNull(rightVal)) {
            // LCA found
            return node;
        }
        if(Objects.nonNull(leftVal)) {
            return leftVal;
        }
        if(Objects.nonNull(rightVal)) {
            return rightVal;
        }
        return null;
    }

    private class Wrapper {
        int key, height;

        Wrapper(int key, int height) {
            this.key = key;
            this.height = height;
        }
    }
}
