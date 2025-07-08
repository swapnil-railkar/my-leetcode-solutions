package com.leetCode;

import java.util.Arrays;

public class P1751 {
	public int solution(int[][] events, int k) {
        int[][] dp = new int[events.length][k + 1];
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < events.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int maxPoints = getMaxPoints(events, dp, k, 0, 0);
        return maxPoints;
    }

    private int getMaxPoints(int[][] events, int[][] dp, int k, int index, int attended) {
        if (attended == k || index == events.length) {
            return 0;
        }
        if (dp[index][attended] != -1) {
            return dp[index][attended];
        }
        int[] event = events[index];
        // get next event's index
        int nextIndex = getNextIndex(events, event[1], index);
        // attend this event and go to next event's index
        int attendPts = event[2] + getMaxPoints(events, dp, k, nextIndex, attended + 1);
        // do not attend this event and go to next index
        int noAttendPts = getMaxPoints(events, dp, k, index + 1, attended);
        dp[index][attended] = Math.max(attendPts, noAttendPts);
        return dp[index][attended];
    }

    private int getNextIndex(int[][] events, int endDate, int index) {
        int low = index, high = events.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][0] <= endDate) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
