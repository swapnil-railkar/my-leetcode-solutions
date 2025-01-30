package com.leetCode;

import com.leetCode.DsNodes.TreeNode;

import java.util.*;

public class P101 {
    public static void main(String[] args) {

        // Build tree from here
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(2);

        TreeNode ll = new TreeNode(2);
        TreeNode rl = new TreeNode(2);

        root.left = l;
        root.right = r;

        l.left = ll;
        r.left = rl;


        // to here.
        // Assuming tree is always correct.
        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        leftMap.put(-19, List.of(-62 , -15 , 101 , 101 , 101 , 55));

        Map<Integer, List<Integer>> rightMap = new HashMap<>();
        rightMap.put(-19, List.of(55 , 101 , 101 , 101 , -15 , -62));
        System.out.println(compareSides(leftMap, rightMap));
//        if (isLeaf(root)) {
//            System.out.println(true);
//        }
//
//        if (eligible(root)) {
//            leftMap = getMapForTree(root.left, new HashMap<>());
//            rightMap = getMapForTree(root.right, new HashMap<>());
//            // Entry for node 26 is missing but for 76 is available
//            System.out.println(compareSides(leftMap, rightMap)); ;
//        } else {
//            System.out.println(false);
//        }
    }

    private static boolean compareSides(final Map<Integer, List<Integer>> leftSide,
                                         final Map<Integer, List<Integer>> rightSide) {

        boolean flag ;
        if (leftSide.size() != rightSide.size()) {
            return false;
        } else {
            final List<Integer> leftNodes = new ArrayList<>(leftSide.keySet());
            final List<Integer> rightNodes = new ArrayList<>(rightSide.keySet());

            for (Integer leftNode : leftNodes) {
                if (!rightNodes.contains(leftNode)) {
                    return false;
                }
                final List<Integer> leftChilds = leftSide.get(leftNode);
                final List<Integer> rightChilds = rightSide.get(leftNode);
                // even -> left child, odd-> right child
                if (leftChilds.size() != rightChilds.size()) {
                    // This check is redundant.
                    return false;
                }

                if (leftChilds.size() > 2) {
                    flag = compareForCollidingNodes(leftChilds, rightChilds);

                    if (!flag) {
                        return false;
                    }
                } else {
                    flag = comparePairs(leftChilds, rightChilds);
                }

                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean compareForCollidingNodes(final List<Integer> leftChilds,
                                                    final List<Integer> rightChilds) {
        // Size will always be 4 (or more).
        // even -> left child, odd-> right child.
        List<List<Integer>> leftPairs = new ArrayList<>(List.of(
                List.of(leftChilds.get(0), leftChilds.get(1)),
                List.of(leftChilds.get(2), leftChilds.get(3))
        ));

        List<List<Integer>> rightPairs = new ArrayList<>(List.of(
                List.of(rightChilds.get(0), rightChilds.get(1)),
                List.of(rightChilds.get(2), rightChilds.get(3))
        ));

        if (leftPairs.contains(List.of(101, 101)) && rightPairs.contains(List.of(101, 101))) {

            leftPairs.remove(List.of(101, 101));
            rightPairs.remove(List.of(101, 101));
            return comparePairs(leftPairs.get(0), rightPairs.get(0));
        }

        return (comparePairs(leftPairs.get(0), rightPairs.get(1))
                && comparePairs(leftPairs.get(1), rightPairs.get(0)))
                || (comparePairs(leftPairs.get(0), rightPairs.get(0))
                && comparePairs(leftPairs.get(1), rightPairs.get(1)));
    }

    private static boolean comparePairs(final List<Integer> leftChilds, final List<Integer> rightChilds) {
        return Objects.equals(leftChilds.get(0), rightChilds.get(1))
                && Objects.equals(leftChilds.get(1), rightChilds.get(0));
    }

    private static Map<Integer, List<Integer>> getMapForTree(final TreeNode root,
                                                             final Map<Integer, List<Integer>> map) {
        if (root == null) {
            return map;
        }

        if (isLeaf(root)) {
            List<Integer> childNodes = new ArrayList<>();
            if (map.containsKey(root.val)) {
                childNodes = map.get(root.val);
            }
            childNodes.add(101);
            childNodes.add(101);
            map.put(root.val, childNodes);
        }

        if (!isLeaf(root)) {
            List<Integer> childNodes = new ArrayList<>();
            if (map.containsKey(root.val)) {
                childNodes = map.get(root.val);
            }
            childNodes.add(isPresent(root.left) ? root.left.val : 101);
            childNodes.add(isPresent(root.right) ? root.right.val : 101);
            map.put(root.val, childNodes);
        }
        getMapForTree(root.left, map);
        getMapForTree(root.right, map);

        return map;
    }

    private static boolean isLeaf(final TreeNode node) {
        return node.left == null && node.right == null;
    }

    private static boolean isPresent(final TreeNode node) {
        return node != null;
    }

    private static boolean eligible(TreeNode node) {
        return (node.left != null && node.right != null) && (node.left.val == node.right.val);
    }
}
