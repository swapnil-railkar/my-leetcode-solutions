package com.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P1441 {
	public List<String> solution(int[] target, int n) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        List<String> op = new ArrayList<>();
        for (int j = 1; j <= n; j++) {
            if (i >= target.length) {
                break;
            }
            if (!stk.isEmpty()) {
                if (i == 0 && stk.peek() != target[0]) {
                    stk.pop();
                    op.add("Pop");
                }
                if (i > 0 && stk.peek() != target[i - 1]) {
                    stk.pop();
                    op.add("Pop");
                }
            }
            if (j == target[i]) {
                i++;
            }
            stk.push(j);
            op.add("Push");
        }
        return op;
    }
}
