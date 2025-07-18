package com.leetCode;

import java.util.PriorityQueue;

public class P2163 {
	public long solution(int[] nums) {
		int n = nums.length / 3;
		long[] leftSum = new long[n + 1];
		long[] rightSum = new long[n + 1];
		PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		PriorityQueue<Integer> min = new PriorityQueue<>();
		
		long leftTotal = 0;
		for(int i = 0; i< 2*n; i++) {
			leftTotal += nums[i];
			max.add(nums[i]);
			if(max.size() > n) {
				leftTotal -= max.poll();
			}
			if(i >= n - 1) {
				leftSum[i - n + 1] = leftTotal;
			}
		}
		
		long rightTotal = 0;
		for(int i = nums.length - 1; i>= n; i--) {
			rightTotal += nums[i];
			min.add(nums[i]);
			if(min.size() > n) {
				rightTotal -= min.poll();
			}
			if(i <= 2*n) {
				rightSum[i - n] = rightTotal;
			}
		}
		
		long minDiff = Long.MAX_VALUE;
		for(int i =0; i< n + 1; i++) {
			minDiff = Math.min(minDiff, leftSum[i] - rightSum[i]);
		}
		return minDiff;
	}
}
