package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P3440 {
	public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        List<Integer> distances = new ArrayList<>();
        distances.add(startTime[0]);
        for(int i = 1; i< startTime.length; i++) {
            distances.add(startTime[i] - endTime[i - 1]);
        }
        distances.add(eventTime - endTime[endTime.length - 1]);

        int[] leftMax = new int[distances.size()];
        int[] rightMax = new int[distances.size()];
        leftMax[0] = distances.get(0);
        rightMax[rightMax.length - 1] = distances.get(distances.size() - 1);

        for(int i = 1; i < leftMax.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], distances.get(i));
        }
        for(int i = rightMax.length - 2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], distances.get(i));
        }
        
        int max = 0;
        for(int i = 1; i< distances.size(); i++) {
            int dist = distances.get(i - 1) + distances.get(i);
            int blockDist = endTime[i - 1] - startTime[i - 1];
            int left = i >= 2 ? leftMax[i - 2] : -1;
            int right = i == distances.size() - 1 ? -1 : rightMax[i + 1];
            if(left >= blockDist || right >= blockDist) {
                dist += blockDist;
            }
            max = Math.max(dist, max);
        }
        return max;
    }
}
