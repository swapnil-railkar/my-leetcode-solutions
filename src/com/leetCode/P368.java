package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P368 {

    public List<Integer> largestDivisibleSubset(int[] num) {
        if (num.length == 1) {
            List<Integer> subset = new ArrayList<>();
            subset.add(num[0]);
            return subset;
        }

        Arrays.sort(num);
        int startIndex = num[0] == 1 ? 1 : 0;
        int endIndex = num.length - 1;
        List<List<Integer>> subSets =  getSubsets(num, startIndex, endIndex);
        return getMaxSubList(subSets);
    }

    public List<List<Integer>> getSubsets(int[] num, int startIndex, int endIndex) {
        if ((endIndex - startIndex) < 2) {
            List<List<Integer>> minSub = new ArrayList<>();
            if (startIndex == endIndex) {
                List<Integer> sub = new ArrayList<>();
                sub.add(num[startIndex]);
                minSub.add(sub);
            } else if ((endIndex - startIndex) == 1) {
                if (num[startIndex] % num[endIndex] == 0) {
                    List<Integer> sub = new ArrayList<>();
                    sub.add(num[startIndex]);
                    sub.add(num[endIndex]);
                    minSub.add(sub);
                } else {
                    List<Integer> sub1 = new ArrayList<>();
                    sub1.add(num[startIndex]);

                    List<Integer> sub2 = new ArrayList<>();
                    sub2.add(num[endIndex]);
                    minSub.add(sub1);
                    minSub.add(sub2);
                }
            }
            return minSub;
        }

        int mid = (startIndex + endIndex) / 2;
        List<List<Integer>> leftSub = getSubsets(num, startIndex, mid);
        List<List<Integer>> rightSub = getSubsets(num, mid + 1, endIndex);

        return combineSubsets(leftSub, rightSub);
    }
    
    public List<List<Integer>> combineSubsets(List<List<Integer>> leftSubsets, List<List<Integer>> rightSubsets) {
 
        for (List<Integer> leftSub : leftSubsets) {
            List<Integer> candidates = new ArrayList<>();
            for (Integer leftNum : leftSub) {
                for (List<Integer> rightSub : rightSubsets) {
                    boolean isCandidate = true;
                    for (Integer rightNum : rightSub) {
                        if ((leftNum > rightNum) && (leftNum % rightNum != 0)) {
                            isCandidate = false;
                        } else if ((rightNum > leftNum) && (rightNum % leftNum != 0)) {
                            isCandidate = false;
                        }

                        if (isCandidate) {
                            candidates.add(rightNum);
                        }
                    }
                    
                }
            }
            updateLeftSubset(leftSub, candidates);
        }
        return leftSubsets;
    }

    private void updateLeftSubset(List<Integer> leftSub, List<Integer> candidates) {
    }

    private List<Integer> getMaxSubList(List<List<Integer>> subLists) {
        List<Integer> maxSub = subLists.get(0);

        for (List<Integer> subList : subLists) {
            if (subList.size() > maxSub.size()) {
                maxSub = subList;
            }
        }

        return maxSub;
    }
}


//    private List<Integer> getMaxSubset(int[] num) {
//        List<List<Integer>> subsets = new ArrayList<>();
//        List<List<Integer>> ssForNum;
//        List<Integer> subset;
//        int maxSize = 1;
//        List<Integer> maxSublist = new ArrayList<>();
//        maxSublist.add(num[0]);
//        boolean containsOne = num[0] == 1;
//        int startIndex = containsOne ? 1 : 0;
//        for (int i=startIndex; i<= num.length/2; i++) {
//            // curr num in array num[i]
//            ssForNum = new ArrayList<>();
//            subset = new ArrayList<>();
//            subset.add(num[i]);
//            ssForNum.add(subset);
//            for (int j =i + 1; j< num.length; j++) {
//                // for each integer either enter in suitable subset or create new subset
//                boolean canAddInSubSet = true;
//                boolean newSubsetFound = false;
//                subset = new ArrayList<>();
//                subset.add(num[j]);
//                for (List<Integer> sub : ssForNum) {
//                    // find suitable subset
//                    canAddInSubSet = true;
//                    for (Integer n: sub) {
//                        if ((n > num[j]) && (n % num[j] != 0)) {
//                            canAddInSubSet = false;
//                        } else if ((n < num[j]) && (num[j] % n != 0)) {
//                            canAddInSubSet = false;
//                        } else if ((num[j] % n == 0) || (n % num[j] == 0)) {
//                            if (!subset.contains(n)) {
//                                newSubsetFound = true;
//                                boolean addInNewSub = true;
//                                for (Integer newSubNum : subset) {
//                                    if ((n > newSubNum) && (n % newSubNum != 0)) {
//                                        addInNewSub = false;
//                                        break;
//                                    } else if ((n < newSubNum) && (newSubNum % n != 0)) {
//                                        addInNewSub = false;
//                                        break;
//                                    }
//                                }
//                                if (addInNewSub) {
//                                    subset.add(subset.size() - 1, n);
//                                }
//                            }
//                        }
//                    }
//
//                    if (canAddInSubSet) {
//                        sub.add(num[j]);
//                        if (sub.size() > maxSize) {
//                            maxSublist = sub;
//                            maxSize = sub.size();
//                        }
//                    }
//                }
//
//                if (newSubsetFound && !canAddInSubSet) {
//
//                    if (!ssForNum.contains(subset)) {
//                        ssForNum.add(subset);
//                    }
//                }
//
//            }
//
//            subsets.addAll(ssForNum);
//        }
//
//        if (containsOne) {
//            if (maxSublist.isEmpty()) {
//                maxSublist = subsets.get(0);
//            }
//            maxSublist.add(0, 1);
//            return maxSublist;
//        }
//        return maxSublist;
//    }