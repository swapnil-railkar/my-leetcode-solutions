package com.leetCode.Arrays;

import com.leetCode.P146;

public class Question {
    public static void main(String[] args) {
        P146 question = null;
        question = new P146(2);
        question.put(1,1);
        question.put(2,2);
        System.out.println(question.get(1));
        question.put(3,3);
        System.out.println(question.get(2));
        question.put(4,4);
        System.out.println(question.get(1));
        System.out.println(question.get(3));
        System.out.println(question.get(4));
    }

}