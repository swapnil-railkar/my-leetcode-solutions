package com.leetCode;

import java.util.Stack;

public class P155 {

	Stack<Wrapper> stack = null;
    public P155() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        int currentMin = stack.isEmpty() ? val : Math.min(val, stack.peek().min);
        stack.add(new Wrapper(val, currentMin));
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        Wrapper wrapper = stack.peek();
        return wrapper.val;
    }
    
    public int getMin() {
        Wrapper wrapper = stack.peek();
        return wrapper.min;
    }

    private class Wrapper {
        int val;
        int min;
        Wrapper(int value, int min) {
            this.val = value;
            this.min = min;
        }
    }
}
