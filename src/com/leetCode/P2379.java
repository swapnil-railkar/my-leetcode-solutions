package com.leetCode;

public class P2379 {

	public int solution(String blocks, int k) {
		int minChanges = Integer.MAX_VALUE;
		int count = 0;
		
		//init window.
		for(int i = 0; i< k; i++) {
			if(blocks.charAt(i) == 'W') {
				count++;
			}
		}
		
		if(k == blocks.length() || count == 0) {
			return count;
		} else {
			minChanges = count;
			for(int i = 1; (i + k)<= blocks.length(); i++) {
				int endIndex = (i + k) - 1;
				if(blocks.charAt(i - 1) != blocks.charAt(endIndex)) {
					if(blocks.charAt(i - 1) == 'B' && blocks.charAt(endIndex) == 'W') {
						count++;
					} else if(blocks.charAt(i - 1) == 'W' && blocks.charAt(endIndex) == 'B') {
						count--;
						if(count < minChanges) {
							minChanges = count;
						}
					}
				}
			}
		}
		
		return minChanges;
	}
}
