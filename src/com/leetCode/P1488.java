package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P1488 {
	public int[] solution(int[] rains) {
        int[] ans = new int[rains.length];
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< rains.length; i++) {
            if(rains[i] > 0) {
                if(numIndexMap.containsKey(rains[i])) {
                    int index = findIndex(list, numIndexMap.get(rains[i]), i);
                    if(index == -1) {
                        return new int[] {};
                    }
                    ans[index] = rains[i];
                    list.remove((Integer) index);
                }
                numIndexMap.put(rains[i], i);
                ans[i] = -1;
            } else {
                list.add(i);
            }
        }
        for(int index : list) {
            ans[index] = 1;
        }
        return ans;
    }

    private int findIndex(List<Integer> indexes, int start, int end) {
        int left = 0, right = indexes.size() - 1;
        int index = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int val = indexes.get(mid);
            if(val >= start && val <= end) {
                right = mid - 1;
                index = val;
            } else if(val < start) {
                left = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}
