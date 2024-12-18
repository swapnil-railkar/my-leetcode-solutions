package com.leetCode.Arrays;

public class Question {
    public static void main(String[] args) {
        P56 question = new P56();
        int[][] array = {{2,3},{4,6},{5,7},{3,4}};
        int[][] answer = question.solution(array);
        for(int[] interval: answer) {
        	System.out.println(interval[0] + "\t" + interval[1]);
        }
    }

}