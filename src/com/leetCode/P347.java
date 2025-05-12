package com.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P347 {

	public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for(int num : nums) {
            int freq = numFrequencyMap.getOrDefault(num, 0) + 1;
            numFrequencyMap.put(num, freq);
        }
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.freq, a.freq));
        for(int num : numFrequencyMap.keySet()) {
            pq.add(new Wrapper(num, numFrequencyMap.get(num)));
        }
        for(int i =0; i< k; i++) {
            Wrapper wrapper = pq.remove();
            ans[i] = wrapper.num;
        }
        return ans;
    }

    private static class Wrapper {
        int num;
        int freq;
        Wrapper(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }
    }
}
