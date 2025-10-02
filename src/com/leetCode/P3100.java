package com.leetCode;

public class P3100 {
	public int solution(int numBottles, int numExchange) {
        int count = numBottles;
        int rem = numBottles;
        while(rem >= numExchange) {
            rem -= numExchange;
            count++;
            rem++;
            numExchange++;
        }
        return count;
    }
}
