package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P25 {
	public ListNode reverseKGroup(ListNode head, int k) {
        ListNode startNode = head;
        ListNode startNodeOfPrevWindow = null;
        ListNode endNode = getEndNode(startNode, k);
        while(endNode != null) {
            reverseWindow(startNode, endNode);
            if(startNode == head) {
                head = endNode;
            } else if(startNodeOfPrevWindow != null) {
                startNodeOfPrevWindow.next = endNode;
            }
            startNodeOfPrevWindow = startNode;
            startNode = startNode.next;
            endNode = getEndNode(startNode, k);
        }
        return head;
    }

    private ListNode getEndNode(ListNode startNode, int k) {
        int index = 1;
        ListNode currNode = startNode;
        while(k > index && currNode != null) {
            currNode = currNode.next;
            index++;
        }
        return currNode;
    }

    private void reverseWindow(ListNode startNode, ListNode endNode) {
        ListNode n1 = startNode;
        ListNode n2 = startNode.next;
        startNode.next = endNode.next;
        while(n2 != startNode.next) {
            ListNode temp = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = temp;
        }
    }
}
