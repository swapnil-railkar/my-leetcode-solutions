package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P1590 {
	public int solution(int[] nums, int p) {
        long sum = 0;
        for(int n: nums) {
            sum += n;
        }
        if(sum % p == 0) {
            return 0;
        }
        int target = (int) (sum % p);
        long currSum = 0;
        Map<Integer, Integer> remIndexMap = new HashMap<>();
        int minLength = nums.length;
        remIndexMap.put(0, -1);
        for(int i = 0; i< nums.length; i++) {
            currSum += nums[i];
            int currRem = (int) (currSum % p);
            int req = (currRem - target + p)%p;
            if(remIndexMap.containsKey(req)) {
                int length = i - remIndexMap.get(req);
                minLength = Math.min(minLength, length);
            }
            remIndexMap.put(currRem, i);
        }
        return minLength == nums.length ? -1 : minLength;
    }
}
