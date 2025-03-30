package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P763 {

	public List<Integer> solution(String str) {
		List<Integer> sizeCount = new ArrayList<>();

		for(int i =0; i< str.length(); i++) {
			int count = 0;
			int lastIndex = str.lastIndexOf(str.charAt(i));
			while(i < str.length() && i<= lastIndex) {
				count++;
				lastIndex = Math.max(lastIndex, str.lastIndexOf(str.charAt(i)));
				i++;
			}
			i--;
			sizeCount.add(count);
		}

		return sizeCount;
	}
}
