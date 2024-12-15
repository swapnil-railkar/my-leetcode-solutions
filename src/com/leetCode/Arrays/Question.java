package com.leetCode.Arrays;

import java.util.List;

public class Question {
    public static void main(String[] args) {
        P56 question = new P56();
        int[][] intervals = {
        		{2,3},{4,6},{5,7},{3,4}
        };
        int[][] answer = question.solution(intervals);
        for(int[] interval : answer) {
        	System.out.println(interval[0] + "\t" + interval[1]);
        }
        
    }

}