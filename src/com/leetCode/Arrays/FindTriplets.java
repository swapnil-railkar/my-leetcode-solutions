package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTriplets {

    public int solution(int[] num1, int[] num2) {
        int type1Triplets = 0;
        int type2Triplets = 0;
        Map<Integer, Integer> type1Map = new HashMap<>();
        Map<Integer, Integer> type2Map = new HashMap<>();
        for (Integer n1: num1) {
            if (type1Map.containsKey(n1)) {
                type1Triplets += type1Map.get(n1);
            } else {
                int count = getTripletForNum(Math.pow(n1, 2), num2);
                type1Triplets += count;
                type1Map.put(n1, count);
            }
        }

        for (Integer n2: num2) {
            if (type2Map.containsKey(n2)) {
                type2Triplets += type2Map.get(n2);
            } else {
                int count = getTripletForNum(Math.pow(n2, 2), num1);
                type2Triplets += count;
                type2Map.put(n2, count);
            }
        }

        return type1Triplets + type2Triplets;
    }

    private int getTripletForNum(double square, int[] num) {
        List<Double> candidates = new ArrayList<>();

        for (Integer n : num) {
            if (n % square == 0 || square % n == 0) {
                candidates.add(Double.valueOf(n));
            }
        }

        if (candidates.size() < 2) {
            return 0;
        }
        return countTripletForCandidates(square, candidates);
    }

    private int countTripletForCandidates(double square, List<Double> candidates) {
        int count = 0;
        for (int i=0; i< candidates.size(); i++) {
            for (int j = i+1; j< candidates.size(); j++) {
                if (candidates.get(i) * candidates.get(j) == square) {
                    count++;
                }
            }
        }
        return count;
    }
}
