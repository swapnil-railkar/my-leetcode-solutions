package com.leetCode;

public class NumberOfValidBst {

    public static void main(String[] args) {
        System.out.println(getSum(5));
    }

    private static int getSum(int num) {
        if (num == 1) {
            return 1;
        } else {
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                int leftNums = i - 1;
                int rightNums = num - i;
                if (leftNums <= 0 || rightNums <= 0) {
                    if (leftNums <= 0) {
                        sum += getPossibleBst(rightNums);
                    }

                    if (rightNums <= 0) {
                        sum += getPossibleBst(leftNums);
                    }
                } else {
                    sum+=getPossibleBst(leftNums)*getPossibleBst(rightNums);
                }
            }
            if (num % 2 == 0) {
                return sum*2;
            } else {
                int middleNum = (num / 2) + 1;
                int leftNums = middleNum - 1;
                int rightNums = num - middleNum;
                return (sum*2) + getPossibleBst(leftNums)*getPossibleBst(rightNums);
            }
        }

    }
    private static int getPossibleBst(int node) {
        if (node == 1) {
            return 1;
        }

        if (node == 2) {
            return 2;
        }

        return getSum(node);

    }
}
