package com.leetCode.Arrays;

import java.util.List;

import com.leetCode.P65;

public class Question {
    public static void main(String[] args) {
        P65 question = new P65();
        List<String> questions = List.of("4e+");
        for(String q: questions) {
        	boolean answer = question.solution(q);
        	System.out.println(q + " : " + answer);
        }
       
        
    }

}