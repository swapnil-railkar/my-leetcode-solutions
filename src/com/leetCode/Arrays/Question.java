package com.leetCode.Arrays;

import com.leetCode.P24;
import com.leetCode.DsNodes.ListNode;

public class Question {
    public static void main(String[] args) {
        P24 problem = new P24();
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);


        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        
        head = problem.solution(head);
        
        while(head != null) {
        	System.out.println(head.val);
        	head = head.next;
        }

        
    }

}