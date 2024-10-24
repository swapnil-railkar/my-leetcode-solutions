package com.leetCode.DsNodes;

public class Node {
    int val;
    public Node left;
    public Node right;
    public Node next;

    public Node(){}

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }
}
