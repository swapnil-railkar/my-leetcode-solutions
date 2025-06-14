package com.leetCode;

public class P2566 {
	public int solution(int num) {
        String numStr = Integer.toString(num);
        String maxNumStr = new String(numStr);
        int index = 0;
        while(index < numStr.length() && numStr.charAt(index) == '9') {
            index++;
        }
        if(index < numStr.length()) {
            char toReplace = numStr.charAt(index);
            maxNumStr = maxNumStr.replaceAll(String.valueOf(toReplace), "9");
        }
        String minNumStr = new String(numStr);
        index = 0;
        while(index < numStr.length() && numStr.charAt(index) == '0') {
            index++;
        }
        if(index < numStr.length()) {
            char toReplace = numStr.charAt(index);
            minNumStr = minNumStr.replaceAll(String.valueOf(toReplace), "0");
        }
        return Integer.parseInt(maxNumStr) - Integer.parseInt(minNumStr);
    }
}
