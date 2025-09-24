package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P166 {
	public String solution(int numerator, int denominator) {
		if(numerator == 0) {
			return "0";
		}
		long num = Math.abs((long) numerator);
		long den = Math.abs((long) denominator);
		
		StringBuilder ans = new StringBuilder();
		if(numerator > 0 ^ denominator > 0) {
			ans.append('-');
		}
		ans.append(num/den);
		num %= den;
		if(num == 0) {
			return ans.toString();
		}
		ans.append('.');
		Map<Long, Integer> numIndexMap = new HashMap<>();
		while(num != 0) {
			numIndexMap.put(num, ans.length());
			num *= 10;
			ans.append(num / den);
			num %= den;
			if (numIndexMap.containsKey(num)) {
                int repeatStartPosition = numIndexMap.get(num);
                ans.insert(repeatStartPosition, "(");
                ans.append(")");
                break;
            }
		}
		return ans.toString();
    }
}
