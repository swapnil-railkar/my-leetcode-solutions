package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P2221 {
	public int solution(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        for(int num : nums) {
            curr.add(num);
        }
        while(curr.size() > 1) {
            List<Integer> next = new ArrayList<>();
            for(int i = 1; i< curr.size(); i++) {
                next.add((curr.get(i - 1) + curr.get(i)) % 10);
            }
            curr = next;
        }
        return curr.get(0);
    }
}
