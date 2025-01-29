package com.leetCode.Tree;

import com.leetCode.DsNodes.TreeNode;

import java.util.*;

public class P102 {

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
        if (isLeaf(root)) {
            return List.of(List.of(root.val));
        } else {
            List<Integer> lvl = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<List<Integer>> lvlOrder = new ArrayList<>();
            lvl.add(root.val);
            lvlOrder.add(lvl);
            return getLevelOrder(lvlOrder, queue);
        }
    }

    private static List<List<Integer>> getLevelOrder(List<List<Integer>> lvlOrder, Queue<TreeNode> queue) {
        if (queue.isEmpty()) {
            return lvlOrder;
        }

        TreeNode currNode = queue.remove();
        if (currNode.left != null) {
            queue.add(currNode.left);
        }
        if (currNode.right != null) {
            queue.add(currNode.right);
        }

        int index = getLastIndexOfElement(lvlOrder, currNode);
        addNodeToLvlOrder(lvlOrder, currNode, index);

        return getLevelOrder(lvlOrder, queue);
    }

    private static void addNodeToLvlOrder(List<List<Integer>> lvlOrder, TreeNode currNode, int lastIndex) {
        List<Integer> childNodes = new ArrayList<>();
        if (currNode.left != null) {
            childNodes.add(currNode.left.val);
        }
        if (currNode.right != null) {
            childNodes.add(currNode.right.val);
        }

        if (!childNodes.isEmpty()) {
            int index = lastIndex + 1;
            if (index > lvlOrder.size()-1) {
                lvlOrder.add(childNodes);
            } else {
                List<Integer> oldChild = lvlOrder.get(index);
                oldChild.addAll(childNodes);
            }
        }
    }

    private static int getLastIndexOfElement (List<List<Integer>> lvlNodes, TreeNode currNode) {

        for (int i = lvlNodes.size() - 1; i >= 0; i--) {
            if (lvlNodes.get(i).contains(currNode.val)) {
                if ((i - 1) > 0 && getParentValues(lvlNodes.get(i-1)).contains(currNode.val)) {
                    return i - 1;
                }
                return i;
            }
        }
        return -1;
    }

    private static List<Integer> getParentValues(List<Integer> parentLvl) {
        List<Integer> parentValues = new ArrayList<>();
        for(int i = parentLvl.size()/2 ; i < parentLvl.size(); i++) {
            parentValues.add(parentLvl.get(i));
        }
        return parentValues;
    }

    private static boolean isLeaf(final TreeNode node) {
        return node.left == null && node.right == null;
    }
}
