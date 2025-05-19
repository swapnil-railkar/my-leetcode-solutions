package com.leetCode;

import java.util.HashSet;
import java.util.Set;

import com.leetCode.DsNodes.ListNode;

public class P160 {
	public ListNode solution(ListNode headA, ListNode headB) {
        Set<ListNode> nodes = new HashSet<>();
        while(headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(nodes.contains(headB)) {
                return headB;
            }
            headB= headB.next;
        }
        return null;
    }
}
