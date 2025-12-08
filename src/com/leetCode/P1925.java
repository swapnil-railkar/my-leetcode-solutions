package com.leetCode;

public class P1925 {
	public int solution(int n) {
        int count = 0;
        for(int num1 = 1; num1<= n; num1++) {
            for(int num2 = num1 + 1; num2<= n; num2++) {
                int square = (num1 * num1) + (num2 * num2);
                int root = isPerfectSquare(square);
                if(root != -1 && root <= n) {
                    count += 2;
                }
            }
        }
        return count;
    }

    private int isPerfectSquare(int square) {
        int root = (int) Math.sqrt(square);
        return (root * root) == square ? root : -1;
    }
}