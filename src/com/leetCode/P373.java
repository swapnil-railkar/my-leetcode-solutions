package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class P373 {
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.sum, a.sum));
        for(int i = 0; i< nums1.length; i++) {
            for(int j = 0; j< nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                if(pq.size() >= k && pq.peek().sum <= sum) {
                    break;
                } else {
                    while(pq.size() >= k && pq.peek().sum > sum) {
                        pq.poll();
                    }
                    pq.add(new Wrapper(nums1[i], nums2[j]));   
                }
            }
        }
        while(!pq.isEmpty()) {
            Wrapper w = pq.poll();
            answer.add(List.of(w.n1, w.n2));
        }
        return answer;
    }

    private class Wrapper {
        int n1;
        int n2;
        int sum;
        Wrapper(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
            this.sum = n1 + n2;
        }
    }
}
