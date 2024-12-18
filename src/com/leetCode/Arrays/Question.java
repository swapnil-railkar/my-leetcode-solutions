package com.leetCode.Arrays;

import com.leetCode.P86;
import com.leetCode.DsNodes.ListNode;

public class Question {
    public static void main(String[] args) {
        P86 question = new P86();
        int[] values = {1,4,3,2,5,2};
        ListNode head = convertToList(values);
        ListNode mergedHead = question.solution(head, 3);
        while(mergedHead != null) {
        	System.out.println(mergedHead.val);
        	mergedHead = mergedHead.next;
        }
    }
    
    private static ListNode convertToList(int[] values) {
    	ListNode head = null;
    	ListNode ptr = null;
    	
    	for(int value : values) {
    		if(head == null) {
    			ptr = new ListNode(value);
    			head = ptr;
    		} else {
    			ptr.next = new ListNode(value);
    			ptr = ptr.next;
    		}
    	}
    	return head;
    }

}