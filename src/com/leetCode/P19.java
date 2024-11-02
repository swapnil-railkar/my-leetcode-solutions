package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P19 {
	
	public ListNode solution(ListNode head, int n) {
		ListNode fastPtr = head;
		ListNode slowPtr = null;
		ListNode prevNode = null;
		int position = 1;
		
		while(fastPtr != null) {
			if (slowPtr != null) {
				prevNode = slowPtr;
				slowPtr = slowPtr.next;
			}
			if (position == n) {
				slowPtr = head;
			}
			fastPtr = fastPtr.next;
			position++;
		}
		
		if (slowPtr != null && prevNode != null) {
			prevNode.next = slowPtr.next;
			slowPtr.next = null;
			return head;
		} else if (slowPtr != null && prevNode == null) {
			return head.next;
		} else if (slowPtr == null) {
			return head;
		}
		return head;
	}
}
