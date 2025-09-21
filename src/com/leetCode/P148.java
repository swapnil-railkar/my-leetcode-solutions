package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.leetCode.DsNodes.ListNode;

public class P148 {
	public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        head = null;
        ListNode curr = head;
        for(int val : list) {
            if(head == null) {
                head = new ListNode(val);
                curr = head;
            } else {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
        }
        return head;
    }
}
