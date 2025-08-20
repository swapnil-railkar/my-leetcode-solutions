package com.leetCode;

import com.leetCode.DsNodes.ListNode;

public class P234 {
	public boolean solution(ListNode head) {
        if(head.next == null) {
            return true;
        }
        int length = 1;
        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            length++;
        }
        length--;
        int mid = length % 2 == 0 ? (length / 2) + 1 : (length / 2) + 2;
        ListNode midNode = head;
        length = 1;
        while(length < mid) {
            midNode = midNode.next;
            length++;
        }
        ListNode reverseHead = reverse(midNode);
        while(reverseHead != null) {
            if(head.val != reverseHead.val) {
                return false;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        if(head.next == null) {
            return head;
        }
        if(head.next.next == null) {
            ListNode newHead = head.next;
            newHead.next = head;
            head.next = null;
            return newHead;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        head.next = null;
        curr.next = prev;
        return curr;
    }
}
