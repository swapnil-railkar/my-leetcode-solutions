package com.leetCode;

public class P33 {

    public static void main(String[] args) {
        int[] num = {1,3};
        int key = 3;
        int index = getIndexOfKey(num, key);
        System.out.println(index);
    }

    public static int getIndexOfKey(int[] num, int key) {
        int startIndex = 0;
        int endIndex = num.length - 1;
        int mid =  (startIndex + endIndex) / 2;

        while (startIndex <= endIndex) {
            if (num[mid] == key) {
                return mid;
            }else if (canExistInLeftHalf(num, startIndex, mid, endIndex, key)) {
                endIndex = mid - 1;
                mid = (startIndex + endIndex) / 2;
            } else {
                startIndex = mid + 1;
                mid = (startIndex + endIndex) / 2;
            }
        }

        return -1;
    }

    private static boolean canExistInLeftHalf(int[] num, int startIndex, int mid, int endIndex, int key) {
        if ((mid - 1) < startIndex) {
            return false;
        }
        if ((mid + 1) > endIndex) {
            return true;
        }
        int leftMidDiff = getPositiveDiff(key - num[mid-1]);
        int rightMidDiff = getPositiveDiff(key - num[mid+1]);
        int startDiff = getPositiveDiff(key - num[startIndex]);
        int endDiff = getPositiveDiff(key - num[endIndex]);
        if ((leftMidDiff < rightMidDiff) || (leftMidDiff < endDiff)) {
            return true;
        }

        if ((startDiff < rightMidDiff) || (startDiff < endDiff)) {
            return true;
        }
        return false;
    }

    private static int getPositiveDiff(int diff) {
        if (diff < 0) {
            return diff * -1;
        }
        return diff;
    }
}
