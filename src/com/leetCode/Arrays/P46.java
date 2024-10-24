package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class P46 {

    public List<List<Integer>> solution(int[] num) {
        List<List<Integer>> combinations = new ArrayList<>();
        for (Integer n : num) {
            if (combinations.isEmpty()) {
                List<Integer> baseCombination = new ArrayList<>();
                baseCombination.add(n);
                combinations.add(baseCombination);
            } else {
                combinations = getCombinationsForNum(combinations, n);
            }
        }
        return combinations;
    }

    private List<List<Integer>> getCombinationsForNum(List<List<Integer>> combinations, int num) {
        List<List<Integer>> newCombinations = new ArrayList<>();

        for (List<Integer> combination : combinations) {
            for (int i =0; i< combination.size(); i++) {
                List<Integer> newCombination = new ArrayList<>(combination);
                newCombination.add(i, num);
                newCombinations.add(newCombination);
            }
            List<Integer> endCombination = new ArrayList<>(combination);
            endCombination.add(num);
            newCombinations.add(endCombination);
        }
        return newCombinations;
    }
}
