package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P3741 {
	public int solution(int[] nums) {
        Map<Integer, List<Integer>> numsIndexList = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            List<Integer> indices = numsIndexList.getOrDefault(nums[i], new ArrayList<>());
            indices.add(i);
            numsIndexList.put(nums[i], indices);
        }
        int minDist = Integer.MAX_VALUE;
        for(int key : numsIndexList.keySet()) {
            if(numsIndexList.get(key).size() > 2) {
                minDist = Math.min(minDist, getMinDistance(numsIndexList.get(key)));
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private int getMinDistance(List<Integer> indices) {
        int minDist = Integer.MAX_VALUE;
        for(int i = 0; i< indices.size() - 2; i++) {
            int x = indices.get(i);
            int y = indices.get(i + 1);
            int z = indices.get(i + 2);
            int dist = Math.abs(x - y) + Math.abs(y - z) + Math.abs(z - x);
            minDist = Math.min(minDist, dist);
        }
        return minDist;
    }
}
