package com.leetCode;

import java.util.List;
import java.util.PriorityQueue;

public class P632 {
	public int[] solution(List<List<Integer>> nums) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int max =Integer.MIN_VALUE;
        for(int i = 0; i< nums.size(); i++) {
            int[] entry = {nums.get(i).get(0), i, 0};
            pq.add(entry);
            max = Math.max(max, nums.get(i).get(0));
        }

        int leftVal = 0;
        int rightVal = Integer.MAX_VALUE;
        while(pq.size() == nums.size()) {
            int[] curr = pq.poll();
            int val = curr[0];
            int list = curr[1];
            int ele = curr[2];

            if(max - val < rightVal - leftVal) {
                rightVal = max;
                leftVal = val;
            }

            if(ele + 1 < nums.get(list).size()) {
                int[] entry = {nums.get(list).get(ele + 1), list, ele + 1};
                pq.add(entry);
                max = Math.max(max, nums.get(list).get(ele + 1));
            }
        }
        return new int[] {leftVal, rightVal};
    }
}
