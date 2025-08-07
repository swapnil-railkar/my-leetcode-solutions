package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leetCode.DsNodes.TreeNode;

public class P199 {
	public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<Integer> rsv = new ArrayList<>();
        List<TreeNode> lvl = new ArrayList<>();
        lvl.add(root);
        updateRsv(rsv, lvl);
        return rsv;
    }

    private void updateRsv(List<Integer> rsv, List<TreeNode> lvl) {
        if (!lvl.isEmpty()) {
            rsv.add(lvl.get(lvl.size() - 1).val);
            List<TreeNode> nextLvl = new ArrayList<>();
            for (TreeNode node : lvl) {
                if (node.left != null) {
                    nextLvl.add(node.left);
                }
                if (node.right != null) {
                    nextLvl.add(node.right);
                }
            }
            updateRsv(rsv, nextLvl);
        }
    }
}
