package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P103 {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> lvl = new ArrayList<>();
        lvl.add(root);
        return getLOC(new ArrayList<>(), lvl, false);
    }
    
    private List<List<Integer>> getLOC(List<List<Integer>> lot, List<TreeNode> currLvl, boolean reverse) {
        if(currLvl.isEmpty()) {
            return lot;
        }
        // process current lvl in reverse or regular order.
        if(reverse) {
            reverseTraversal(lot, currLvl);
        } else {
            traversal(lot, currLvl);
        }
        List<TreeNode> nxtLvl = new ArrayList<>();
        for(int i = 0; i< currLvl.size(); i++) {
            TreeNode node = currLvl.get(i);
            if(node.left != null) {
                nxtLvl.add(node.left);
            }
            if(node.right != null) {
                nxtLvl.add(node.right);
            }
        }
        return getLOC(lot, nxtLvl, !reverse);
    }
    
    private void reverseTraversal(List<List<Integer>> lot, List<TreeNode> lvl) {
        List<Integer> values = new ArrayList<>();
        for(int i = lvl.size() - 1; i>=0; i--) {
            values.add(lvl.get(i).val);
        }
        lot.add(values);
    }
    
    private void traversal(List<List<Integer>> lot, List<TreeNode> lvl) {
        List<Integer> values = new ArrayList<>();
        for(int i = 0; i< lvl.size(); i++) {
            values.add(lvl.get(i).val);
        }
        lot.add(values);
    }
}
