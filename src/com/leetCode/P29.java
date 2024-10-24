package com.leetCode;
public class P29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int dividend = -2147483648 , divisor = -1;
        int quotient = divide(dividend, divisor);
        System.out.println(dividend + " \\ " +divisor+ " = "+quotient);
	}

	private static int divide(int dividend, int divisor) {
		// TODO Auto-generated method stub
		int ans = 0, tmp, quotient;
		boolean isNeg = false;
		
		if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
			isNeg = true;
		}
		
		// absolute values of dividend and divisor.
		int absDividend = getAbs(dividend);
		int absDivisor = getAbs(divisor);
		
		while(absDividend >= absDivisor) {
			tmp = absDivisor;
			quotient = 1;
			//loop until for a quotient (divisor * quotient ) > dividend hold true.
			//quotient should be multiple of 2.
			while(tmp <= absDividend) {
				tmp<<=1; // bitwise left shift = multiplication by 2.
				quotient<<=1;
			}
			
			ans += quotient>>1;// bitwise right shift = division by 2.
			absDividend -= tmp>>1;
		}
		
		ans = getQuo(ans, isNeg);
		
		return ans;
	}

	private static int getQuo(int quotient, boolean isNeg) {
		// TODO Auto-generated method stub
		if(isNeg == true && (quotient <= Integer.MIN_VALUE || quotient >= Integer.MAX_VALUE)) {
			return Integer.MIN_VALUE;
		}else if(isNeg == false && (quotient <= Integer.MIN_VALUE || quotient >= Integer.MAX_VALUE)) {
			return Integer.MAX_VALUE;
		}else if(isNeg) {
			return ~quotient+1;//2's compliment.
		}
		return quotient;
	}
	
	public static int getAbs(int num) {
		if(num <= Integer.MIN_VALUE) {
			return Integer.MAX_VALUE;
		}
		return Math.abs(num);
	}

}
