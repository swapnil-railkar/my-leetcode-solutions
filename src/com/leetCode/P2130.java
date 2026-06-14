package com.leetCode;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.DsNodes.ListNode;

public class P2130 {
	public int solution(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int max = Integer.MIN_VALUE;
        int left = 0, right = list.size() - 1;
        while(left < right) {
            int sum = list.get(left) + list.get(right);
            max = Math.max(sum, max);
            left++;
            right--;
        }
        return max;
    }
}
