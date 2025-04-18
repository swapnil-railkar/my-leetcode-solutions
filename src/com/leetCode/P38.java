package com.leetCode;

public class P38 {

	public String solution(int num) {
		return getRLEString(1, "1", num);
	}

	private String getRLEString(int num, String rleStr, int target) {
		if(num == target) {
			return rleStr;
		} 
		String nextRle = rleBuilder(rleStr);
		return getRLEString(num + 1, nextRle, target);
	}

	private String rleBuilder(String numStr) {
		StringBuilder rle = new StringBuilder();
		char currNum = numStr.charAt(0);
		int count = 1;
		for(int i = 1; i< numStr.length(); i++) {
			if(currNum == numStr.charAt(i)) {
				count++;
			} else {
				rle.append(count);
				rle.append(currNum);
				currNum = numStr.charAt(i);
				count = 1;
			}
		}
		rle.append(count);
		rle.append(currNum);
		return rle.toString();
	}
}
