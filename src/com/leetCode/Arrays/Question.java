package com.leetCode.Arrays;

import java.util.List;

import com.leetCode.String.P17;

public class Question {
    public static void main(String[] args) {
        P17 problem = new P17();
        String num = "2356";
        List<String> combinations = problem.solution(num);
        for(String combination: combinations) {
        	System.out.println(combination);
        }
    }

}