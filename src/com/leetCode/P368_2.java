package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class P368_2 {

    public List<Integer> largestDivisibleSubset(int[] num) {
        if (num.length == 1) {
            List<Integer> subset = new ArrayList<>();
            subset.add(num[0]);
            return subset;
        }

        Arrays.sort(num);
        return getMaxSubList(num);
    }

    private List<Integer> getMaxSubList(int[] num) {
        List<Integer> maxList = Collections.emptyList();
        for (int i = num.length - 1; i >= num.length/ 2; i--) {
            List<List<Integer>> subLists = new ArrayList<>();
            // Initialize
            List<Integer> subList = new ArrayList<>();
            subList.add(num[i]);
            subLists.add(subList);
            for (int j = i - 1; j >= 0; j--) {
                boolean isUpdated = updateSublist(subLists, num[j]);
                if (!isUpdated && (num[i] % num[j] == 0)) {
                    List<Integer> newSubList = new ArrayList<>();
                    newSubList.add(num[i]);
                    newSubList.add(num[j]);
                    subLists.add(newSubList);
                }
            }
            List<Integer> currMax = getMaxList(subLists);
            if (currMax.size() > maxList.size()) {
                maxList = currMax;
            }
        }
        return maxList;
    }

    private List<Integer> getMaxList(List<List<Integer>> subLists) {
        List<Integer> max = subLists.get(0);
        for (List<Integer> sub : subLists) {
            if (sub.size() > max.size()) {
                max = sub;
            }
        }
        return max;
    }

    private boolean updateSublist(List<List<Integer>> sublists, int num) {
        boolean addedInSublist = false;

        for (List<Integer> sublist : sublists) {
            boolean canAddInSublist = true;
            for (int i = 0;  i< sublist.size() && canAddInSublist; i++ ) {
                if ((num > sublist.get(i)) && (num % sublist.get(i) != 0)) {
                    canAddInSublist = false;
                } else if ((num < sublist.get(i)) && (sublist.get(i) % num != 0)) {
                    canAddInSublist = false;
                }
            }
            if (canAddInSublist) {
                sublist.add(num);
                addedInSublist = true;
            }
        }
        return addedInSublist;
    }

}
