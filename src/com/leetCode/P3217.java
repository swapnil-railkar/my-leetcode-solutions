package com.leetCode;

import java.util.HashSet;
import java.util.Set;

import com.leetCode.DsNodes.ListNode;

public class P3217 {
	public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null) {
            if(set.contains(curr.val)) {
                if(prev != null) {
                    ListNode temp = curr.next;
                    prev.next = temp;
                    curr.next = null;
                    curr = temp;
                } else {
                    // head is in the set
                    head = curr.next;
                    curr = head;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
