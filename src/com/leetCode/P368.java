package com.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class P368 {
	
	public List<Integer> solution(int[] num) {
		List<Integer> allDivSub = new ArrayList<>();
		// init all div sub
		allDivSub.add(0);
		for(int i =0; i< num.length; i++) {
			int remLength = num.length - i;
			if(remLength <= allDivSub.size()) {
				return getNumsList(num,allDivSub);
			}
			PriorityQueue<List<Integer>> allSubs = getSubsetsForIndex(i, num.length, allDivSub.size(), num);
			List<Integer> indexMaxSub = allSubs.remove();
			if(indexMaxSub != null && indexMaxSub.size() > allDivSub.size()) {
				allDivSub = indexMaxSub;
			}
		}
		return getNumsList(num,allDivSub);
	}
	
	private List<Integer> getNumsList(int[] num, List<Integer> subset) {
		List<Integer> numList = new ArrayList<>();
		for(int index : subset) {
			numList.add(num[index]);
		}
		return numList;
	}
	
	private PriorityQueue<List<Integer>> getSubsetsForIndex(int index, int limit, int currMax, int[] num) {
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.size(), a.size()));
		Queue<List<Integer>> q = new LinkedList<>();
		// init q
		for(int i = index + 1; i< limit; i++) {
			List<Integer> subset = new ArrayList<>();
			subset.add(index);
			subset.add(i);
			q.add(subset);
		}
		
		while(!q.isEmpty()) {
			List<Integer> subset = q.poll();
			if(subset.size() > currMax) {
				List<Integer> maxSub = pq.peek();
				if(maxSub == null) {
					if(isDivisibleSub(subset, num)) {
						pq.add(subset);
					}
				}
				if(maxSub != null) {
					if(subset.size() > maxSub.size() && isDivisibleSub(subset, num)) {
						pq.add(subset);
					}
				}
			}
			int lastIndex = subset.get(subset.size() - 1);
			
			// add new subsets to q.
			for(int i = lastIndex + 1; i< limit; i++) {
				List<Integer> newSub = new ArrayList<>(subset);
				newSub.add(i);
				q.add(newSub);
			}		
		}
		return pq;
	}
	
	private boolean isDivisibleSub(final List<Integer> subset, int[] num) {
		for(int i =0; i< subset.size(); i++) {
			for(int j=i + 1; j< subset.size(); j++) {
				int big = Math.max(num[subset.get(i)], num[subset.get(j)]);
				int small = Math.min(num[subset.get(i)], num [subset.get(j)]);
				if(big % small != 0) {
					return false;
				}
			}
		}
		return true;
	}
    
}
