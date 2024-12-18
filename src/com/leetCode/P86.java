package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P86 {
	
	public ListNode solution(ListNode head, int num) {
	
		if(head == null) {
			return null;
		}
		
		ListNode minValues = null;
		ListNode minValuesHead = null;
		
		ListNode maxValues = null;
		ListNode maxValuesHead = null;
		
		while(head!= null) {
			if(head.val < num) {
				// populate minValue list
				if(minValuesHead == null) {
					minValues = new ListNode(head.val);
					minValuesHead = minValues;
				} else {
					minValues.next = new ListNode(head.val);
					minValues = minValues.next;
				}
			} else {
				// populate maxValue list
				if(maxValuesHead == null) {
					maxValues = new ListNode(head.val);
					maxValuesHead = maxValues;
				} else {
					maxValues.next = new ListNode(head.val);
					maxValues = maxValues.next;
				}
			}
			head = head.next;
		}
	
		if (minValues == null) {
			return maxValuesHead;
		} else if (maxValues == null) {
			return minValuesHead;
		} else {
			minValues.next = maxValuesHead;
			return minValuesHead;
		}
		
	}
}
