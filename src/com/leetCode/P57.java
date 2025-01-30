package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P57 {

    public int[][] solution(int[][] intervals, int[] newInterval) {
        List<List<Integer>> intervalsList = new ArrayList<>();
        boolean newEntryAdded = false;

        for (int i = 0; i< intervals.length; i++) {
            if (!newEntryAdded) {
                if (isIndependentEntry(i, intervals, newInterval)) {
                    // Independent entry.
                    List<Integer> ipEntry = new ArrayList<>();
                    ipEntry.add(newInterval[0]);
                    ipEntry.add(newInterval[1]);
                    intervalsList.add(ipEntry);
                    newEntryAdded = true;

                    addCurrEntryToList(intervals[i], intervalsList);
                } else if (isDependantEntry(i, intervals, newInterval)) {
                    // dependant entry.
                    List<Integer> dpEntry = new ArrayList<>();
                    dpEntry.add(Math.min(intervals[i][0], newInterval[0]));
                    while (i < intervals.length && canMerge(i, intervals, newInterval) ) {
                        i++;
                    }
                    if (i >= intervals.length) {
                        dpEntry.add(newInterval[1]);
                    } else {
                        dpEntry.add(Math.max(intervals[i][1], newInterval[1]));
                    }
                    intervalsList.add(dpEntry);
                    newEntryAdded = true;
                } else {
                    addCurrEntryToList(intervals[i], intervalsList);
                }
            } else {
                addCurrEntryToList(intervals[i], intervalsList);
            }

        }

        if (!newEntryAdded) {
            List<Integer> ipEntry = new ArrayList<>();
            ipEntry.add(newInterval[0]);
            ipEntry.add(newInterval[1]);
            intervalsList.add(ipEntry);
        }

        return convertListToArray(intervalsList);
    }

    private boolean canMerge(int currIndex,int[][] intervals, int[] newInterval) {
        if (currIndex + 1 < intervals.length) {
            return intervals[currIndex][1] <= newInterval[1] && intervals[currIndex + 1][0] <= newInterval[1];
        }
        return false;
    }

    private void addCurrEntryToList(int[] interval, List<List<Integer>> intervals) {
        List<Integer> list = new ArrayList<>();
        list.add(interval[0]);
        list.add(interval[1]);
        intervals.add(list);
    }

    private boolean isIndependentEntry( int currIndex, int[][] intervals, int[] newInterval) {
        if (currIndex > 0) {
            return intervals[currIndex][0] > newInterval[1]
                    && intervals[currIndex - 1][1] < newInterval[0];
        } else {
            return intervals[currIndex][0] > newInterval[1];
        }
    }

    private boolean isDependantEntry(int currIndex, int[][] intervals, int[] newInterVal) {
        return intervals[currIndex][1] == newInterVal[0]
                || (intervals[currIndex][0] <= newInterVal[0] && intervals[currIndex][1] >= newInterVal[0])
                || (intervals[currIndex][0] <= newInterVal[1] && intervals[currIndex][1] >= newInterVal[1]);
    }

    private int[][] convertListToArray(List<List<Integer>> updatedIntervals) {
        int[][] updatedInterval = new int[updatedIntervals.size()][2];

        for (int i = 0; i < updatedIntervals.size(); i++) {
            List<Integer> interval = updatedIntervals.get(i);
            updatedInterval[i][0] = interval.get(0);
            updatedInterval[i][1] = interval.get(1);
        }

        return updatedInterval;
    }
}
