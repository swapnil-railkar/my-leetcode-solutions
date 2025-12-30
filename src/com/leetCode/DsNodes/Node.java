package com.leetCode.DsNodes;

public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node child;
    public Node prev;
    public Node random;

    public Node(){}

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
        this.child = null;
        this.prev = null;
    }
}
