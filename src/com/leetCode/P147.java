package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P147 {
	public ListNode insertionSortList(ListNode head) {
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            ListNode temp = head;
            if (curr.val < temp.val) {
                // new head found.
                prev.next = prev.next.next;
                curr.next = temp;
                head = curr;
                curr = prev.next;
            } else {
                while (temp.next != curr && temp.next.val < curr.val) {
                    temp = temp.next;
                }
                if (temp.next != curr) {
                    prev.next = prev.next.next;
                    curr.next = temp.next;
                    temp.next = curr;
                    curr = prev.next;
                } else {
                    prev = prev.next;
                    curr = curr.next;
                }
            }
        }
        return head;
    }
}
