package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

public class P1022 {
	public int sumRootToLeaf(TreeNode root) {
        return getSum(root, new StringBuilder());
    }

    private int getSum(TreeNode node, StringBuilder sb) {
        if(node == null) {
            return 0;
        }
        sb.append((char) (node.val + '0'));
        int sum = 0;
        if(node.left == null && node.right == null) {
            // leaf node.
            sum = Integer.parseInt(sb.toString(), 2);
        } else {
            int leftSum = getSum(node.left, sb);
            int rightSum = getSum(node.right, sb);
            sum = leftSum + rightSum;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sum;
    }
}
