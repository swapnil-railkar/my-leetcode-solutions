package com.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.DsNodes.ListNode;

public class P2095 {
	public ListNode deleteMiddle(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        if(list.size() == 1) {
            return null;
        }
        int mid = (int) Math.floor(list.size() / 2);
        list.get(mid - 1).next = list.get(mid).next;
        list.get(mid).next = null;
        return head;
    }
}
