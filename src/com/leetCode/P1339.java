package com.leetCode;

import java.util.HashMap;
import java.util.Map;

import com.leetCode.DsNodes.TreeNode;

public class P1339 {
	public int solution(TreeNode root) {
        Map<TreeNode, Long> nodeSumMap = new HashMap<>();
        long total = getNodeSum(root, nodeSumMap);
        long maxProduct = getMaxProduct(root, nodeSumMap, 0, total);
        long modVal = maxProduct % 1_000_000_007;
        return (int) modVal;
    }

    public long getMaxProduct(TreeNode node, Map<TreeNode, Long> nodeSumMap, long maxProduct, long total) {
        if(node == null) {
            return maxProduct;
        }
        
        // if we cut left child of current node from tree.
        long leftCutSum = total - nodeSumMap.getOrDefault(node.left, 0L);
        long leftCutMul = leftCutSum * nodeSumMap.getOrDefault(node.left, 0L);

        // if we cut right child of current node from tree.
        long rightCutSum = total - nodeSumMap.getOrDefault(node.right, 0L);
        long rightCutMul = rightCutSum * nodeSumMap.getOrDefault(node.right, 0L);

        maxProduct = Math.max(maxProduct, Math.max(leftCutMul, rightCutMul));
        return Math.max(getMaxProduct(node.left, nodeSumMap, maxProduct, total),
         getMaxProduct(node.right, nodeSumMap, maxProduct, total));
    }

    public long getNodeSum(TreeNode node, Map<TreeNode, Long> nodeSumMap) {
        if (node == null) {
            return 0;
        }
        long tot = getNodeSum(node.left, nodeSumMap) + getNodeSum(node.right, nodeSumMap) + node.val;
        nodeSumMap.put(node, tot);
        return tot;
    }
}
