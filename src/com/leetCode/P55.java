package com.leetCode;

public class P55 {

    public static void main(String[] args) {
        int[] num = {2,3,1,1,4};
        boolean canCross = canReachGoalPos(num);
        System.out.print(canCross);
    }

    private static boolean canReachGoalPos(int[] num) {
        int goalPos = num.length - 1;

        for (int i = num.length - 2;  i >=0; i--) {
            if ((i + num[i]) >= goalPos) {
                goalPos = i;
            }
        }
        return goalPos == 0;
    }
}

