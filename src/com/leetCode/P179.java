package com.leetCode;

import java.util.PriorityQueue;

public class P179 {
	public String solution(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> compareNums(b, a));
        for(int n : nums) {
            pq.add(Integer.toString(n));
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()) {
            ans.append(pq.poll());
        }
        if(ans.charAt(0) == '0') {
            return "0";
        }
        return ans.toString();
    }

    private int compareNums(String s1, String s2) {
        StringBuilder op1 = new StringBuilder(s1);
        op1.append(s2);
        StringBuilder op2 = new StringBuilder(s2);
        op2.append(s1);
        return op1.toString().compareTo(op2.toString());
    }
}
