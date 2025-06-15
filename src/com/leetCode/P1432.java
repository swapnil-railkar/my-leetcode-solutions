package com.leetCode;

public class P1432 {
	public int solution(int num) {
		String numStr = Integer.toString(num);
        String max = new String(numStr);
        int maxIndex = 0;
        while(maxIndex < numStr.length() && numStr.charAt(maxIndex) == '9') {
            maxIndex++;
        }
        if(maxIndex < numStr.length()) {
            max = max.replaceAll(String.valueOf(numStr.charAt(maxIndex)), "9");
        }
        String min = new String(numStr);
        int minIndex = 0;
        while(minIndex < min.length() && (min.charAt(minIndex) == '1' || min.charAt(minIndex) == '0')) {
            minIndex++;
        }
        if(minIndex < min.length()) {
            if(minIndex == 0) {
                min = min.replaceAll(String.valueOf(numStr.charAt(0)), "1");
            } else {
                min = min.replaceAll(String.valueOf(numStr.charAt(minIndex)), "0");
            }
        }
        return Integer.parseInt(max) - Integer.parseInt(min);
    }
}
