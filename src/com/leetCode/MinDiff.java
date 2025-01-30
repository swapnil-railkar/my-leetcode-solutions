package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class MinDiff {
    public int getMinDiff(int[] num) {
        List<List<Integer>> wrapper = getMinMaxThree(num);
        List<Integer> maxThree = wrapper.get(0);
        List<Integer> minThree = wrapper.get(1);
        int min = Integer.MAX_VALUE;

        for (int n : maxThree) {
            int maxDiff = getDiffForChange(getClone(num), maxThree, minThree, n);
            int minDiff = getDiffForChange(getClone(num), minThree, maxThree, n);
            if (min > Math.min(maxDiff, minDiff)) {
                min = Math.min(maxDiff, minDiff);
            }
        }

        for (int n : minThree) {
            int maxDiff = getDiffForChange(getClone(num), maxThree, minThree, n);
            int minDiff = getDiffForChange(getClone(num), minThree, maxThree, n);
            if (min > Math.min(maxDiff, minDiff)) {
                min = Math.min(maxDiff, minDiff);
            }
        }

        return min;
    }

    private List<List<Integer>> getMinMaxThree(int[] arr) {
        List<Integer> minThree = updateMinThree(arr);
        List<Integer> maxThree = updateMaxThree(arr);
        List<List<Integer>> wrapper = new ArrayList<>();

        wrapper.add(minThree);
        wrapper.add(maxThree);
        return wrapper;
    }

    private List<Integer> updateMaxThree(int[] num) {
        List<Integer> minThree = new ArrayList<>();
        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        for (int n : num) {
            if (n > firstMax) {
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = n;
            } else if (n > secMax) {
                thirdMax = secMax;
                secMax = n;
            } else if (n > thirdMax) {
                thirdMax = n;
            }
        }

        minThree.add(firstMax);
        minThree.add(secMax);
        minThree.add(thirdMax);
        return minThree;
    }

    private List<Integer> updateMinThree(int[] num) {
        List<Integer> minThree = new ArrayList<>();
        int firstmin = Integer.MAX_VALUE;
        int secmin = Integer.MAX_VALUE;
        int thirdmin = Integer.MAX_VALUE;
        for (int n : num) {
            if (n < firstmin) {
                thirdmin = secmin;
                secmin = firstmin;
                firstmin = n;
            } else if (n < secmin) {
                thirdmin = secmin;
                secmin = n;
            } else if (n < thirdmin) {
                thirdmin = n;
            }
        }

        minThree.add(firstmin);
        minThree.add(secmin);
        minThree.add(thirdmin);
        return minThree;
    }


    // changes for min = updating for minThree and num is from maxThree
    private int getDiffForChange(int[] arr, List<Integer> list, List<Integer> extraList, Integer num) {
        int count =0;
        for (int i=0; i<arr.length && count < 3; i++) {
            if (list.contains(arr[i]) && !extraList.contains(arr[i]) && arr[i] != num) {
                arr[i] = num;
                count++;
            }

        }


        if(count < 3) {
            int dummy = count;
            int[] c1 = getClone(arr);
            int diff1, diff2;
            for (int i = 0; i<extraList.size() && dummy < 3; i++) {
                for (int j=0; j<c1.length && dummy < 3; j++) {
                    if (extraList.get(i) == c1[j] && c1[j] != num) {
                        c1[j] = num;
                        dummy++;
                    }

                }
            }
            diff1 = getMaxMinDiff(c1);
            dummy = count;
            int[] c2 = getClone(arr);
            for (int i = 2; i>=0 && dummy < 3; i--) {
                for (int j=0; j<c2.length && dummy < 3; j++) {
                    if (extraList.get(i) == c2[j] && c2[j] != num) {
                        c2[j] = num;
                        dummy++;
                    }

                }
            }
            diff2 = getMaxMinDiff(c2);

            return Math.min(diff1,diff2);


        }


        return getMaxMinDiff(arr);
    }

    private int getMaxMinDiff(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for(int num: arr) {
            if (num < min) {
                min = num;
            } else if (num > max) {
                max = num;
            }
        }

        return max - min;
    }

    private int[] getClone(int[] num) {
        int[] clone = new int[num.length];
        System.arraycopy(num, 0, clone, 0, num.length);
        return clone;
    }
}
