package com.leetCode;

import java.util.HashSet;
import java.util.Set;

import com.leetCode.DsNodes.TreeNode;

public class P543 {
	public int solution(TreeNode root) {
        Set<Integer> distances = new HashSet<>();
        populateDistances(root, distances);
        int max = 0;
        for (int distance : distances) {
            max = Math.max(max, distance);
        }
        return max;
    }

    private int populateDistances(TreeNode root, Set<Integer> distances) {
        if (root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int leftDistance = populateDistances(root.left, distances);
        int rightDistance = populateDistances(root.right, distances);
        distances.add(leftDistance + rightDistance);
        return Math.max(leftDistance, rightDistance) + 1;
    }
}
