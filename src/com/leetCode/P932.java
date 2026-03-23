package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P932 {
	public int[] solution(int n) {
        Map<Integer, List<Integer>> dp = new HashMap<>();
        dp.put(1, List.of(1));
        List<Integer> list = getArray(n, dp);
        int[] ans = new int[list.size()];
        int i = 0;
        for(int num : list) {
            ans[i++] = num;
        }
        return ans;
    }

    private List<Integer> getArray(int n, Map<Integer, List<Integer>> dp) {
        if(dp.containsKey(n)) {
            return dp.get(n);
        }
        List<Integer> left = getArray((n + 1)/2, dp);
        List<Integer> right = getArray(n/2, dp);
        List<Integer> result = new ArrayList<>();
        for(int num : left) {
            result.add(2*num - 1);
        }
        for(int num : right) {
            result.add(2*num);
        }
        dp.put(n, result);
        return result;
    }
}
