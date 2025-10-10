package com.leetCode;

public class P3494 {
	public long solution(int[] skill, int[] mana) {
        long[] prev = new long[skill.length + 1];
        for(int i = 1; i< prev.length; i++) {
            prev[i] = prev[i - 1] + (skill[i - 1] * mana[0]);
        }
        for(int i = 1; i< mana.length; i++) {
            long[] curr = new long[skill.length + 1];
            long startTime = getStartTime(prev, skill, mana[i]);
            curr[0] = startTime;
            for(int j = 1; j< curr.length; j++) {
                curr[j] = curr[j - 1] + (skill[j - 1] * mana[i]);
            }
            prev = curr;
        }
        return prev[skill.length];
    }

    private long getStartTime(long[] prev, int[] skill, int mana) {
        long start = 0;
        long end = prev[prev.length - 1];
        long validStartTime = end;
        while(start <= end) {
            long mid = (start + end)/2;
            if(isValidTime(prev, mid, skill, mana)) {
                end = mid - 1;
                validStartTime = mid;
            } else {
                start = mid + 1;
            }
        }
        return validStartTime;
    }

    private boolean isValidTime(long[] prev, long time, int[] skill, int mana) {
        long[] temp = new long[prev.length];
        temp[0] = time;
        for(int i = 1; i< prev.length; i++) {
            temp[i] = temp[i - 1] + (skill[i - 1] * mana);
            if(i < prev.length - 1 && temp[i] < prev[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
