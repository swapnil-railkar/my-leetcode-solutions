package com.leetCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class P295 {
	PriorityQueue<Integer> max = null;
    PriorityQueue<Integer> min = null;
    public P295() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num <= max.peek()) {
            max.add(num);
        } else {
            min.add(num);
        }

        if(max.size() > min.size() + 1) {
            min.add(max.poll());
        } else if(min.size() > max.size()){
            max.add(min.poll());
        }
    }
    
    public double findMedian() {
        if(max.size() == min.size()) {
            return ((double) max.peek() + (double) min.peek()) / 2;
        }
        return (double) max.peek();
    }
}
