package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

import java.util.*;

public class P102_2 {

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
            return getLotValues(lvlOrder, lvl);
        }
    }

    private static List<List<Integer>> getLotValues(List<List<Integer>> lot, List<TreeNode> currLvl) {
        if (currLvl.isEmpty()) {
            return lot;
        }

        updateListForCurrLvl(lot, currLvl);
        List<TreeNode> nextLvl = getNextLvl(currLvl);

        return getLotValues(lot, nextLvl);
    }

    private static List<TreeNode> getNextLvl(List<TreeNode> currLvl) {
        List<TreeNode> nextLvl = new ArrayList<>();
        for (TreeNode currNode : currLvl) {
            if (currNode.left == null && currNode.right != null) {
                nextLvl.add(currNode.right);
            } else if (currNode.right == null && currNode.left != null) {
                nextLvl.add(currNode.left);
            } else if (currNode.left != null && currNode.right != null){
                nextLvl.add(currNode.left);
                nextLvl.add(currNode.right);
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
