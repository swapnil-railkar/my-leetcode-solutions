package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P83 {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode currNode = head.next;
        ListNode prev = head;
        while(currNode != null) {
            if(currNode.val == prev.val) {
                prev.next = currNode.next;
                currNode.next = null;
                currNode = prev.next;
            } else {
                currNode = currNode.next;
                prev = prev.next;
            }
        }
        return head;
    }
}
