package com.leetCode.Arrays;

import java.util.List;

import com.leetCode.String.P10;

public class Question {
    public static void main(String[] args) {
        P15 question = new P15();
        int[] nums = {-1,0,1,2,-1,-4};
        
        List<List<Integer>> answer = question.solution(nums);
        System.out.println(answer);
        
    }

}