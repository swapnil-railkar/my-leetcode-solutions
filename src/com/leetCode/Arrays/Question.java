package com.leetCode.Arrays;

import com.leetCode.P61;
import com.leetCode.DsNodes.ListNode;

public class Question {
    public static void main(String[] args) {
        P61 question = new P61();
        ListNode head = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(5);
        
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        
        head = question.solution(head, 2);
        
        while(head != null) {
        	System.out.println(head.val);
        	head = head.next;
        }
    }

}