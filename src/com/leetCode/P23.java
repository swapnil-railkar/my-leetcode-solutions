package com.leetCode;

import java.util.PriorityQueue;

import com.leetCode.DsNodes.ListNode;

public class P23 {
	public ListNode solution(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for(ListNode head : lists) {
            while(head != null) {
                pq.add(head.val);
                head = head.next;
            }
        }
        ListNode head = null;
        ListNode currHead = null;
        while(!pq.isEmpty()) {
            int val = pq.remove();
            if(head == null) {
                head = new ListNode(val);
                currHead = head; 
            } else {
                currHead.next = new ListNode(val);
                currHead = currHead.next;
            }
        }
        return head;
    }
}
