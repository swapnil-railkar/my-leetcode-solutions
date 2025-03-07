package com.leetCode;

public class P2523 {

	public int[] solution(int left, int right) {
		int num1 = -1;
		int num2 = -1;
		int minNum1 = num1;
		int minNum2 = num2;
		int minDiff = num1 - num2;
		
		for(int i = left; i<= right; i++) {
			if(isPrime(i)) {
				if(num1 == -1) {
					num1 = i;
				} else if(num2 == -1) {
					num2 = i;
					if(num2 - num1 <=2) {
						return new int[] {num1, num2};
					}
				} else {
					num1 = num2;
					num2 = i;
					if(num2 - num1 <=2) {
						return new int[] {num1, num2};
					} else if(num2 - num1 > minDiff) {
						minDiff = num2- num1;
						minNum1 = num1;
						minNum2 = num2;
					}
				}
			}
		}
		
		if(minNum1 == -1 || minNum2 == -1) {
			return new int[] {-1, -1};
		} else {
			return new int[] {minNum1, minNum2};
		}
	}
 	
	private boolean isPrime(final int num) {
		if(num <= 1) {
			return false;
		}
		
		for(int i = 2; i<= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
