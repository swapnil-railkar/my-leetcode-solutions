package com.leetCode;

public class P53 {

    public int solution(int[] num) {
        return findSubArray(num, 0 , num.length - 1);
    }

    private int findSubArray(int[] num, int low, int high) {
        if (high <= low) {
            return num[low];
        } else {
            int mid = (high + low) / 2;
             int leftSum = findSubArray(num, low, mid);
             int rightSum = findSubArray(num, mid + 1, high);
             int crossingSum = findCrossingSubArray(num, low, mid, high);

             if (leftSum >= rightSum && leftSum >= crossingSum) {
                 return leftSum;
             } else if (rightSum >= leftSum && rightSum >= crossingSum) {
                 return rightSum;
             } else {
                 return crossingSum;
             }
        }
    }

    private int findCrossingSubArray(int[] num, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i>= low; i--) {
            sum = sum + num[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i<= high; i++) {
            sum = sum + num[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }

        return leftSum + rightSum;
    }
}
