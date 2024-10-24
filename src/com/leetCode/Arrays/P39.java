package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P39 {

    public List<List<Integer>> solution(int[] num, int total) {
        return getCombinations(new ArrayList<>(), new ArrayList<>(), num, total);
    }

    private List<List<Integer>> getCombinations(List<List<Integer>> combinations, List<Integer> combination, int[] num, int total) {

        if (total == 0) {
            Collections.sort(combination);
            if (!combinations.contains(combination)) {
                combinations.add(combination);
            }
        }else
            for (int n : num) {
            if (n <= total) {
                int newTotal = total - n;
                List<Integer> list = new ArrayList<>(combination);
                list.add(n);
                getCombinations(combinations, list, num, newTotal);
            }
        }

        return combinations;
    }
}
