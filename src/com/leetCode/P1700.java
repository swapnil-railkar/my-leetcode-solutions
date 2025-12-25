package com.leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P1700 {
	public int solution(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int[] choices = new int[2];
        for(int student : students) {
            q.add(student);
            choices[student]++;
        }
        Stack<Integer> stk = new Stack<>();
        for(int i = sandwiches.length - 1; i>= 0; i--) {
            stk.add(sandwiches[i]);
        }
        while(!stk.isEmpty() && !q.isEmpty() && choices[stk.peek()] > 0) {
            int front = q.remove();
            if(stk.peek() == front) {
                choices[stk.pop()]--;
            } else {
                q.add(front);
            }
        }
        return q.size();
    }
}
