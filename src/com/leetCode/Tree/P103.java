package com.leetCode.Tree;

import com.leetCode.DsNodes.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P103 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode rr= new TreeNode(5);

        root.left = l;
        root.right = r;
        l.left = ll;
        r.right = rr;

        List<List<Integer>> answer = getAnswer(root);

        for (List<Integer> lvl : answer) {
            for (int num : lvl) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> getAnswer(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        } else if (isLeaf(root)) {
            return List.of(List.of(root.val));
        } else {
            List<TreeNode> lvl = new ArrayList<>();
            List<List<Integer>> lvlOrder = new ArrayList<>();
            lvl.add(root);
            return getLotValues(lvlOrder, lvl,0);
        }
    }

    private static List<List<Integer>> getLotValues(List<List<Integer>> lot, List<TreeNode> currLvl, int height) {
        if (currLvl.isEmpty()) {
            return lot;
        }

        updateListForCurrLvl(lot, currLvl);
        height++;
        List<TreeNode> nextLvl = getNextLvl(currLvl, height);
        return getLotValues(lot, nextLvl,height);
    }

    private static List<TreeNode> getNextLvl(List<TreeNode> currLvl, int height) {
        List<TreeNode> nextLvl = new ArrayList<>();
        for (TreeNode currNode : currLvl) {
            if (currNode.left == null && currNode.right != null) {
                nextLvl.add(currNode.right);
            } else if (currNode.right == null && currNode.left != null) {
                nextLvl.add(currNode.left);
            } else if (currNode.left != null && currNode.right != null){
                if (height % 2 == 1) {
                    nextLvl.add(currNode.right);
                    nextLvl.add(currNode.left);
                } else {
                    nextLvl.add(currNode.left);
                    nextLvl.add(currNode.right);
                }
            }
        }
        return nextLvl;
    }

    private static void updateListForCurrLvl(List<List<Integer>> lot, List<TreeNode> currLvl) {
        List<Integer> currValues = new ArrayList<>();

        for (TreeNode node : currLvl) {
            if (node != null) {
                currValues.add(node.val);
            }
        }

        if (!currValues.isEmpty()) {
            lot.add(currValues);
        }
    }

    private static boolean isLeaf(final TreeNode node) {
        return node.left == null && node.right == null;
    }

    public void printTree(TreeNode root) {
        List<List<Integer>> answer = getAnswer(root);

        for (List<Integer> lvl : answer) {
            for (int num : lvl) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
