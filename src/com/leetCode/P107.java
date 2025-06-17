package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.leetCode.DsNodes.TreeNode;

public class P107 {
	public List<List<Integer>> solution(TreeNode root) {
        if(root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> currLvl = new ArrayList<>();
        currLvl.add(root);
        Stack<List<Integer>> stk = new Stack<>();
        getLOT(currLvl, stk);
        List<List<Integer>> answer = new ArrayList<>();
        while(!stk.isEmpty()) {
            answer.add(stk.pop());
        }
        return answer;
    }

    private void getLOT(List<TreeNode> currLvl, Stack<List<Integer>> stk) {
        if(!currLvl.isEmpty()) {
            List<Integer> lvl = new ArrayList<>();
            List<TreeNode> nxtLvl = new ArrayList<>();
            for(TreeNode node : currLvl) {
                lvl.add(node.val);
                if(node.left != null) {
                    nxtLvl.add(node.left);
                }
                if(node.right != null) {
                    nxtLvl.add(node.right);
                }
            }
            stk.add(lvl);
            getLOT(nxtLvl, stk);
        }
    }
}
