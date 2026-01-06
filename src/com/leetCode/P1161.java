package com.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class P1161 {
	public int solution(TreeNode root) {
        List<TreeNode> rootLvl = new ArrayList<>();
        rootLvl.add(root);
        return getMaxLevel(rootLvl, 1, Integer.MIN_VALUE, -1);
    }

    private int getMaxLevel(List<TreeNode> currRow, int currLevel, long maxSum, int level) {
        if(currRow.isEmpty()) {
            return level;
        }
        List<TreeNode> nextRow = new ArrayList<>();
        long currSum = 0;
        for(TreeNode node : currRow) {
            currSum += node.val;
            if(node.left != null) {
                nextRow.add(node.left);
            }
            if(node.right != null) {
                nextRow.add(node.right);
            }
        }
        if(currSum > maxSum) {
            maxSum = currSum;
            level = currLevel;
        }
        return getMaxLevel(nextRow, currLevel + 1, maxSum, level);
    }
}
