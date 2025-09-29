package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

public class P108 {
	public TreeNode solution(int[] nums) {
        return appendToTree(nums, 0, nums.length - 1);
    }

    private TreeNode appendToTree(int[] nums, int start, int end) {
        if(end < start || start < 0 || end >= nums.length) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = appendToTree(nums, start, mid - 1);
        node.right = appendToTree(nums, mid + 1, end);
        return node;
    }
}
