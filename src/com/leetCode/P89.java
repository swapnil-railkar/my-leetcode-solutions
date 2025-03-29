package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P89 {

	public List<Integer> solution(int num) {
		List<Integer> answer = new ArrayList<>();
		answer.add(0);
		int limit = (int) Math.pow(2, num);
		for(int i = 1; i< limit; i++) {
			String binStr = Integer.toBinaryString(i);
			String grayStr = getGrayCode(binStr);
			int grayNum = Integer.parseInt(grayStr, 2);
			answer.add(grayNum);
		}
		return answer;
	}
	
	private String getGrayCode(String str) {
		char prevChar = str.charAt(0);
		StringBuilder grayCode = new StringBuilder(String.valueOf(prevChar));
		for(int i =1; i< str.length(); i++) {
			if(prevChar == str.charAt(i)) {
				grayCode.append('0');
			} else {
				grayCode.append('1');
			}
			prevChar = str.charAt(i);
		}
		return grayCode.toString();
	}
}
