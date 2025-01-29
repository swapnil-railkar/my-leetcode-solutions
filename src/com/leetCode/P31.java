package com.leetCode.Arrays;

/**
 *  1.  When in pure desc then sort in asc
 *  2.  When not in pure desc then stay in range
 *  3.  When desc encountered, in range, then swap SI-1th num with greater num with min diff in current array and
 *      sort curr array in asc
 *  4.  If two nums remaining and not in desc, swap them
 *
 *  ARRAY WILL BE EDITED ONLY ONCE
 */
public class P31 {

    public static void main(String[] args) {
        int[] num = {4,3,2,1}; // 1234
        getNextPermutation(num);
        for (int n : num) {
            System.out.print(n);
        }
    }

    private static void getNextPermutation(int[] num) {
        if (num.length == 1) {
            return;
        }
        int startIndex = 0;
        boolean edited = false;
        if (isDsc(num, 0)) {
            sortAsc(num, 0);
            edited = true;
        }

        while (startIndex <= num.length && !edited) {
            if (isDsc(num, startIndex)) {
                // fix logic for isDsc
                int index = getNextBigNumWithMinDiff(num, startIndex);
                swap(num, startIndex - 1, index);
                sortAsc(num, startIndex);
                edited = true;
            } else if (startIndex == num.length - 2) {
                if (isDsc(num, startIndex)) {
                    int index = getNextBigNumWithMinDiff(num, startIndex);
                    swap(num, startIndex - 1, index);
                    sortAsc(num, startIndex);
                } else {
                    swap(num, startIndex, num.length - 1);
                }
                edited = true;

            }
            startIndex++;
        }
    }

    private static int getNextBigNumWithMinDiff(int[] num, int startIndex) {
        int max = num[startIndex - 1];
        int position = startIndex - 1;
        int diff = Integer.MAX_VALUE;

        for (int i = startIndex; i< num.length; i++) {
            if (num[i] > max) {
                int newDiff = num[i] - max;
                if (diff > newDiff) {
                    diff = newDiff;
                    position = i;
                }
            }
        }
        return position;
    }

    private static void swap(int[] num, int startIndex, int endIndex) {
        int temp = num[startIndex];
        num[startIndex] = num[endIndex];
        num[endIndex] = temp;
    }

    private static void sortAsc(int[] num, int startIndex) {
        // Sort array in asc from startIndex.
        for (int i =startIndex; i< num.length; i++) {
            for (int j =i; j< num.length; j++) {
                if(num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
    }

    private static boolean isDsc(int[] num, int startIndex) {
        for (int i = startIndex + 1; i < num.length; i++) {
            if (num[i] > num[i-1]) {
                return false;
            }
        }
        return true;
    }
}
