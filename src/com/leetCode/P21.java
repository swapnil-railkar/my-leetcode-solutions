package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P21 {
    public ListNode solution(ListNode head1, ListNode head2) {
        ListNode mergedList = null;

        // initialize mergedList
        if(head1 != null && head2 != null) {
            // compare values and assign smallest
            if(head1.val < head2.val) {
                mergedList = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                mergedList = new ListNode(head2.val);
                head2 = head2.next; 
            }
        } else if(head1 == null) {
            // first list is empty/ null so return head2
            return head2;
        } else if (head2 == null) {
            // second list is empty/null so return head1
            return head1;
        }


        ListNode head = mergedList;
        while(head1 != null || head2 != null) {
            if(head1 != null && head2!= null) {
                if(head1.val < head2.val) {
                    mergedList.next = new ListNode(head1.val);
                    head1 = head1.next;
                    mergedList = mergedList.next;
                } else {
                    mergedList.next = new ListNode(head2.val);
                    head2 = head2.next;
                    mergedList = mergedList.next;
                }
            } else if(head1 == null) {
                mergedList.next = new ListNode(head2.val);
                head2 = head2.next;
                mergedList = mergedList.next;
            } else if(head2 == null) {
                mergedList.next = new ListNode(head1.val);
                head1 = head1.next;
                mergedList = mergedList.next;
            }
        }

        return head;
    }
}