package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P21 {
    public ListNode solution(ListNode head1, ListNode head2) {
    	ListNode head = null;
        if(head1 == null) {
            return head2;
        } else if(head2 == null) {
            return head1;
        } else {
            // init head
            if(head1.val < head2.val) {
                head = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                head = new ListNode(head2.val);
                head2 = head2.next;
            }
            ListNode currHead = head;
            while(head1 != null || head2 != null) {
                if(head1 != null && head2 != null) {
                    if(head1.val < head2.val) {
                        currHead.next = new ListNode(head1.val);
                        head1 = head1.next;
                    } else {
                        currHead.next = new ListNode(head2.val);
                        head2 = head2.next;
                    }
                } else if(head1 == null) {
                    currHead.next = new ListNode(head2.val);
                    head2 = head2.next;
                } else {
                    currHead.next = new ListNode(head1.val);
                    head1 = head1.next;
                }
                currHead = currHead.next;
            }
        }
        return head;
    }
}