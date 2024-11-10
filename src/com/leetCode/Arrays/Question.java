package com.leetCode.Arrays;

import com.leetCode.String.P10;

public class Question {
    public static void main(String[] args) {
        P10 question = new P10();
        String str = "aaa"; // true
        String pattern = "a*a";
        
        boolean answer = question.solution(str, pattern);
        System.out.println(answer);
        
    }

}