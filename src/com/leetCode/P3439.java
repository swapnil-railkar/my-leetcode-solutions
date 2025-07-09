package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P3439 {
	public int solution(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> dist = new ArrayList<>();
        dist.add(startTime[0]);
        for(int i = 1; i< startTime.length; i++) {
            dist.add(startTime[i] - endTime[i - 1]);
        }
        dist.add(eventTime - endTime[endTime.length - 1]);
        int sum = 0;
        int left = 0, right = k;
        while(left <= right && left < dist.size()) {
            sum += dist.get(left);
            left++;
        }
        int maxSum = sum;
        left = 1;
        right += 1;
        while(right < dist.size()) {
            sum -= dist.get(left - 1);
            sum += dist.get(right);
            maxSum = Math.max(maxSum, sum);
            left++;
            right++;
        }
        return maxSum;
    }
}
