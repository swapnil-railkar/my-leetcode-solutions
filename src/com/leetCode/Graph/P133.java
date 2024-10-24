package com.leetCode.Graph;

import com.leetCode.DsNodes.GNode;

import java.util.*;

public class P133 {

    public static void main(String[] args) {
        GNode node = new GNode(1);
        GNode n2 = new GNode(2);
        GNode n3 = new GNode(3);
        GNode n4 = new GNode(4);

        node.neighbors = List.of(n2, n4);
        n2.neighbors = List.of(node, n3);
        n3.neighbors = List.of(n2, n4);
        n4.neighbors = List.of(node, n3);

        GNode cloned = getClonedGraph(node, new HashMap<>());
        
    }

    //TODO : Set neighbors recursively
    public static GNode getClonedGraph(GNode head, Map<Integer, GNode> map) {
       if (map.containsKey(head.val)) {
           return map.get(head.val);
       }

       GNode copy = new GNode(head.val);
       map.put(head.val, copy);

       for(GNode neighbor : head.neighbors) {
           copy.neighbors.add(getClonedGraph(neighbor, map));
       }
       return head;
    }
}
