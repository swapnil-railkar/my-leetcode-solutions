package com.leetCode;

import java.util.Stack;

public class P232 {
	Stack<Integer> primary = null;
    int firstElement = -1;
    public P232() {
        primary = new Stack<>();
    }
    
    public void push(int x) {
        if(primary.isEmpty()) {
            firstElement = x;
        }
        primary.push(x);
    }
    
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while(!primary.isEmpty()) {
            temp.push(primary.pop());
        }
        int element = temp.pop();
        firstElement = temp.isEmpty() ? -1 : temp.peek();
        while(!temp.isEmpty()) {
            primary.push(temp.pop());
        }
        return element;
    }
    
    public int peek() {
        return firstElement;
    }
    
    public boolean empty() {
        return primary.isEmpty();
    }
}
