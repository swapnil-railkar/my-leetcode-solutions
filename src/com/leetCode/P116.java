package com.leetCode.Tree;

import com.leetCode.DsNodes.Node;

import java.util.*;

public class P116 {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node l = new Node(2);
        Node r = new Node(3);
        Node ll = new Node(4);
        Node lr = new Node(5);
        Node rl = new Node(6);
        Node rr = new Node(7);


        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;

        connect(root);

    }

    private static Node connect(Node root) {
        if (Objects.isNull(root)) {
            return null;
        } else if (isLeaf(root)) {
            // what to return when only one node?
            return root;
        } else {
            int height = getHeight(root);
            int lastRowSize = getExpectedMaxSize(height);
            List<Node> firstLvl = new ArrayList<>();
            firstLvl.add(root);
            return getBfsTraversal(lastRowSize, firstLvl, root);
        }
    }

    private static int getHeight(Node root) {
        if (Objects.isNull(root)) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static int getExpectedMaxSize(int height) {
        if (height == 1) {
            return 1;
        }

        return getExpectedMaxSize(height-1) * 2;
    }

    private static Node getBfsTraversal(int expectedSize, List<Node> visited, Node root) {
        if (visited.size() == expectedSize) {
            getNextLvl(visited);
            return root;
        }

        List<Node> nextLvl = getNextLvl(visited);
        return getBfsTraversal(expectedSize, nextLvl, root);
    }

    private static List<Node> getNextLvl(List<Node> visited) {
        final List<Node> nextLvl = new ArrayList<>();

        for (int i = 1; i < visited.size(); i++) {
            visited.get(i-1).next = visited.get(i);
        }

        for (Node node : visited) {
            if (Objects.nonNull(node.left) && Objects.nonNull(node.right)) {
                nextLvl.add(node.left);
                nextLvl.add(node.right);
            }
        }

        return nextLvl;
    }

    private static boolean isLeaf(Node root) {
        return Objects.isNull(root.left) && Objects.isNull(root.right);
    }
}