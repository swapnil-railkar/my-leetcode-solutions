package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P56 {
	
	public int[][] solution(int[][] intervals) {
		Stack<int[]> processing = new Stack<>();
		List<int[]> processed = new ArrayList<>();
		if(intervals.length == 0) {
			return intervals;
		}
		int intervalsIndex = 0;
		//init
		processing.push(intervals[0]);
		
		while(!processing.isEmpty()) {
			int[] processingInterval = processing.pop();
			int overlappingProcessedEntryIndex = getOverlappingProcessedEntryIndex(processed, processingInterval);
			if(overlappingProcessedEntryIndex == -1) {
				processed.add(processingInterval);
				intervalsIndex++;
				if(intervalsIndex < intervals.length) {
					processing.push(intervals[intervalsIndex]);
				}
			} else {
				int[] overlappingInterval = processed.get(overlappingProcessedEntryIndex);
				processed.remove(overlappingProcessedEntryIndex);
				
				int start = Math.min(processingInterval[0], overlappingInterval[0]);
				int end = Math.max(processingInterval[1], overlappingInterval[1]);
				int[] mergedInterval = {start, end};
				processing.push(mergedInterval);
			}
		}
		
		return convertToArray(processed);
	}
	
	private int getOverlappingProcessedEntryIndex(List<int[]> processed, int[] processingInterval) {
		for(int i=0; i< processed.size(); i++) {
			if(!distinctEntries(processed.get(i), processingInterval)) {
				return i;
			}
		}
		return -1;
	}

	// check whether second array can be merged in first array
	private boolean distinctEntries(int[] processedInterval, int[] processingInterval) {
		int prevStart = processedInterval[0];
		int currStart = processingInterval[0];
		int prevEnd = processedInterval[1];
		int currEnd = processingInterval[1];
		if (prevEnd >= currStart && prevStart <= currEnd) {
			return false;
		}
		return true;
	}
	
	private int[][] convertToArray(final List<int[]> mergedIntervals) {
		int[][] intervals = new int[mergedIntervals.size()][2];
		
		for(int i=0; i< mergedIntervals.size(); i++) {
			intervals[i] = mergedIntervals.get(i);
		}
		
		return intervals;
	}
}
