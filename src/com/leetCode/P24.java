package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P24 {
	
	public ListNode solution(ListNode head) {
		ListNode fNode = head;
		ListNode sNode = null;
		ListNode pivot = null;
		int count = 1;
		
		while(fNode != null) {
			pivot = sNode;
			sNode = fNode;
			fNode = fNode.next;
			count++;
			if (count%2 == 0 && fNode != null) {
				// swap nodes
				if(pivot == null) {
					// first swap
					head = fNode;
					sNode.next = fNode.next;
					fNode.next = sNode;
				} else {
					pivot.next = fNode;
					sNode.next = fNode.next;
					fNode.next = sNode;
				}
				// reset fnode and snode ptrs
				ListNode temp = fNode;
				fNode = sNode;
				sNode = temp;
			}
		}
		return head;
	}
}
