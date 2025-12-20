package com.leetCode;

import java.util.List;
import java.util.Stack;

public class P636 {
	public int[] solution(int n, List<String> logs) {
        Stack<Integer> stk = new Stack<>();
        int[] processTime = new int[n];
        int prevTimeStamp = 0;
        for(String log : logs) {
            String[] info = log.split(":");
            int id = Integer.parseInt(info[0]);
            String action = info[1];
            int timeStamp = Integer.parseInt(info[2]);
            if(stk.isEmpty()) {
                stk.push(id);
                prevTimeStamp = timeStamp;
            } else {
                if(action.equals("end")) {
                    int processId = stk.pop();
                    int time = timeStamp - prevTimeStamp + 1;
                    processTime[processId] = processTime[processId] + time;
                    prevTimeStamp = timeStamp + 1;
                } else {
                    // action == start.
                    int processId = stk.peek();
                    int time = timeStamp - prevTimeStamp;
                    processTime[processId] = processTime[processId] + time;
                    stk.push(id);
                    prevTimeStamp = timeStamp;
                }
            }
        }
        return processTime;
    }
}
