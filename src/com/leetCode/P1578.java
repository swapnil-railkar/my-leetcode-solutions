package com.leetCode;

public class P1578 {
	public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        for(int i = 1; i< colors.length(); i++) {
            if(colors.charAt(i) == colors.charAt(i - 1)) {
                int max = neededTime[i - 1];
                int maxIndex = i - 1;
                int j = i - 1;
                while(j < colors.length() && colors.charAt(j) == colors.charAt(i - 1)) {
                    if(neededTime[j] > max) {
                        max = neededTime[j];
                        maxIndex = j;
                    }
                    j++;
                }
                for(int start = i - 1; start< j; start++) {
                    if(start != maxIndex) {
                        cost += neededTime[start];
                    }
                }
                i = j - 1;
            }
        }
        return cost;
    }
}
