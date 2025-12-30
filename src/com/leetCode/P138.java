package com.leetCode;

import java.util.HashMap;
import java.util.Map;

import com.leetCode.DsNodes.Node;

public class P138 {
	public Node copyRandomList(Node head) {
        Map<Node, Node> newNodeMap = new HashMap<>();
        Node currNode = head;
        while(currNode != null) {
            Node newNode = new Node(currNode.val);
            newNodeMap.put(currNode, newNode);
            currNode = currNode.next;
        }

        currNode = head;
        while(currNode != null) {
            Node newNode = newNodeMap.get(currNode);
            newNode.next = newNodeMap.get(currNode.next);
            newNode.random = newNodeMap.get(currNode.random);
            currNode = currNode.next;
        }
        return newNodeMap.get(head);
    }
}
