package com.leetCode;

import java.util.HashSet;
import java.util.Set;

import com.leetCode.DsNodes.ListNode;

public class P141 {
	
	public boolean solution(ListNode head) {
		Set<ListNode> visitedNodes = new HashSet<>();
        while(head != null) {
            if(visitedNodes.contains(head)) {
                return true;
            }
            visitedNodes.add(head);
            head = head.next;
        }
        return false;
	}
}
