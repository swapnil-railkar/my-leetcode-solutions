package com.leetCode;

public class P1518 {
	public int solution(int numBottles, int numExchange) {
        int count = numBottles;
        int rem = numBottles;
        while(rem >= numExchange) {
            int newBottles = rem / numExchange;
            rem %= numExchange;
            count += newBottles;
            rem += newBottles;
        }
        return count;
    }
}
