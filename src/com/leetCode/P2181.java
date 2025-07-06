package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P2181 {
	public ListNode solution(ListNode head) {
        ListNode currNode = head.next;
        ListNode lastNode = null;
        int sum = 0;
        while(currNode != null) {
            if(currNode.val == 0) {
                ListNode node = new ListNode(sum);
                if(lastNode == null) {
                    head = node;
                } else {
                    lastNode.next = node;
                }
                lastNode = node;
                sum = 0;
            } else {
                sum += currNode.val;
            }
            currNode = currNode.next;
        }
        return head;
    }
}
