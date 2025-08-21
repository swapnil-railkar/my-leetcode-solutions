package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P39 {

	public List<List<Integer>> combinationSum(int[] num, int total) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> combinations = new HashSet<>();
        getCombinations(combinations, new ArrayList<>(), num, total, 0);
        for(List<Integer> combination : combinations) {
            ans.add(combination);
        }
        return ans;
    }

    private void getCombinations(Set<List<Integer>> combinations, List<Integer> combination, int[] num, int rem, int index) {
        if(rem == 0) {
            Collections.sort(combination);
            combinations.add(combination);
            return;
        }
        if(index == num.length || rem < 0) {
            return;
        }
        // don't keep and increase index.
        getCombinations(combinations, combination, num, rem, index + 1);

        // keep and increase index.
        List<Integer> keepIncrease = new ArrayList<>(combination);
        keepIncrease.add(num[index]);
        getCombinations(combinations, keepIncrease, num, rem - num[index], index + 1);

        // keep and don't increase index.
        List<Integer> keepNoIncrease = new ArrayList<>(combination);
        keepNoIncrease.add(num[index]);
        getCombinations(combinations, keepNoIncrease, num, rem - num[index], index);
    }

}
