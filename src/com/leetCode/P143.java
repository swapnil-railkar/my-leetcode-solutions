package com.leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

import com.leetCode.DsNodes.ListNode;

public class P143 {
	public void reorderList(ListNode head) {
        Deque<ListNode> dq = new ArrayDeque<>();
        ListNode curr = head;
        while(curr != null) {
            dq.add(curr);
            curr = curr.next;
        }

        curr = head;
        dq.pollFirst();
        boolean pollFirst = false;
        while(!dq.isEmpty()) {
            ListNode node = null;
            if(pollFirst) {
                node = dq.pollFirst();
            } else {
                node = dq.pollLast();
            }
            node.next = null;
            curr.next = node;
            curr = curr.next;
            pollFirst = !pollFirst;
        }
    }
}
