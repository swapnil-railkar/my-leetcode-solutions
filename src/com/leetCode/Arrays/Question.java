package com.leetCode.Arrays;

import com.leetCode.P21;
import com.leetCode.DsNodes.ListNode;

public class Question {
    public static void main(String[] args) {
        P21 question = new P21();
        ListNode head1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        head1.next = node11;
        node11.next = node12;

        ListNode head2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        head2.next = node21;
        node21.next = node22;

        ListNode head = question.solution(head1, head2);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        
    }

}