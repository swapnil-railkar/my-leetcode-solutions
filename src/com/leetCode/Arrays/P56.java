package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class P56 {
	
	public int[][] solution(int[][] intervals) {
		List<List<Integer>> mergedIntervals = new ArrayList<>();
		for(int i =0; i< intervals.length; i++) {
			List<Integer> interval = new ArrayList<>();
			if (i == 0) {
				//init
				interval.add(intervals[0][0]);
				interval.add(intervals[0][1]);
				mergedIntervals.add(interval);
				continue;
			} else {
				int[] currInterval = intervals[i];
				boolean mergedInterval = false;
				
				// check whether current entry can be merged in any of the recorded entries
				for(int j=0; j< mergedIntervals.size() && !mergedInterval; j++) {
					List<Integer> prevInterval = mergedIntervals.get(j);
					if(!distinctEntries(prevInterval, currInterval)) {
						int minStart = Math.min(prevInterval.get(0), currInterval[0]);
						int maxEnd = Math.max(prevInterval.get(1), currInterval[1]);
						interval.add(minStart);
						interval.add(maxEnd);
						mergedIntervals.set(j, interval);
						mergedInterval = true;
						mergedIntervalFixup(mergedIntervals, minStart, maxEnd, j);
					}
				}
				
				if(!mergedInterval) {
					interval.add(currInterval[0]);
					interval.add(currInterval[1]);
					mergedIntervals.add(interval);
				}
			}
		}
		return convertToArray(mergedIntervals);
	}
	
	private List<List<Integer>> mergedIntervalFixup(List<List<Integer>> mergedIntervals, int startInterval, int endInterval, int position) {
		/*
		 * for each interval after 'position', check whether following intervals can be merged into the interval at 'position'
		 */
		for(int i=0; i< mergedIntervals.size(); i++) {
			int currIntervalStart = mergedIntervals.get(i).get(0);
			int currIntervalEnd = mergedIntervals.get(i).get(1);
			if(i == position) {
				continue;
			}
			// check if whole interval can be included
			if(currIntervalStart >= startInterval && currIntervalEnd <= endInterval) {
				// remove the interval
				mergedIntervals.remove(i);
				i--;
			} else if(currIntervalEnd >= startInterval && currIntervalStart <= startInterval) {
				// new start interval found
				List<Integer> newInterval = new ArrayList<>();
				newInterval.add(currIntervalStart);
				newInterval.add(Math.max(currIntervalEnd, endInterval));
				mergedIntervals.set(i, newInterval);
				mergedIntervalFixup(mergedIntervals, currIntervalStart, Math.max(currIntervalEnd, endInterval), i);
			} else if(currIntervalStart <= endInterval && currIntervalEnd >= endInterval) {
				List<Integer> newInterval = new ArrayList<>();
				newInterval.add(Math.min(currIntervalStart, startInterval));
				newInterval.add(currIntervalEnd);
				mergedIntervals.set(i, newInterval);
				mergedIntervalFixup(mergedIntervals, Math.min(currIntervalStart, startInterval), currIntervalEnd, i);
			}

		}
		return mergedIntervals;
	}

	// check whether second array can be merged in first array
	private boolean distinctEntries(List<Integer> prevInterval, int[] currInterval) {
		int prevStart = prevInterval.get(0);
		int currStart = currInterval[0];
		int prevEnd = prevInterval.get(1);
		int currEnd = currInterval[1];
		if (prevEnd >= currStart && prevStart <= currEnd) {
			return false;
		}
		return true;
	}
	
	private int[][] convertToArray(final List<List<Integer>> mergedIntervals) {
		int[][] intervals = new int[mergedIntervals.size()][2];
		
		for(int i=0; i< mergedIntervals.size(); i++) {
			List<Integer> interval = mergedIntervals.get(i);
			intervals[i][0] = interval.get(0);
			intervals[i][1] = interval.get(1);
		}
		
		return intervals;
	}
}
