package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P78 {

    public List<List<Integer>> solution(int[] num) {
        List<List<Integer>> subsets = getSubsets(num, 0, num.length - 1);
        subsets.add(Collections.emptyList());
        return subsets;
    }

    private List<List<Integer>> getSubsets(int[] num, int low, int high) {
        if (low >= high) {
            List<List<Integer>> subSets = new ArrayList<>();
            List<Integer> baseCase = new ArrayList<>();
            baseCase.add(num[low]);
            subSets.add(baseCase);
            return subSets;
        }

        int mid = (low + high) / 2;

        List<List<Integer>> leftSubSets = getSubsets(num, low, mid);
        List<List<Integer>> rightSubsets = getSubsets(num, mid + 1, high);

        return combineSubsets(leftSubSets, rightSubsets);
    }

    private List<List<Integer>> combineSubsets(List<List<Integer>> leftSets, List<List<Integer>> rightSets) {
        List<List<Integer>> combinedSet = new ArrayList<>();
        combinedSet.addAll(leftSets);
        combinedSet.addAll(rightSets);
        for (List<Integer> leftSet : leftSets) {
            for (List<Integer> rightSet : rightSets) {
                List<Integer> newSet = new ArrayList<>();
                newSet.addAll(leftSet);
                newSet.addAll(rightSet);
                combinedSet.add(newSet);
            }
        }

        return combinedSet;
    }
}
