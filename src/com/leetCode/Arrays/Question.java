package com.leetCode.Arrays;

import com.leetCode.P19;
import com.leetCode.DsNodes.ListNode;

public class Question {
    public static void main(String[] args) {
        P19 problem = new P19();
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        head.next = n1;
        
        head = problem.solution(head, 2);
        
        while(head != null) {
        	System.out.println(head.val);
        	head = head.next;
        }

        
    }

}