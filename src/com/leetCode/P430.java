package com.leetCode;

import com.leetCode.DsNodes.Node;

public class P430 {
	public Node solution(Node head) {
        Node curr = head;
        while(curr != null) {
            if(curr.child != null) {
                Node nextNode = curr.next;
                Node childHead = solution(curr.child);
                curr.child = null;
                curr.next = childHead;
                childHead.prev = curr;
                while(curr.next != null) {
                    curr = curr.next;
                }
                curr.next = nextNode;
                if(nextNode != null) {
                    nextNode.prev = curr;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
