package com.leetCode;

import com.leetCode.DsNodes.Node;

import java.util.*;

public class P116 {

	public Node solution(Node root) {
        if (Objects.isNull(root)) {
            return null;
        }
        connectNext(root, null);
        return root;
    }
    
    private void connectNext(Node node, Node rightNode) {
        if(node != null) {
            node.next = rightNode;
            connectNext(node.left, node.right);
            if(rightNode != null) {
                connectNext(node.right, rightNode.left);
            } else {
                connectNext(node.right, null);
            }
        }
    }
}