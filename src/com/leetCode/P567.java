package com.leetCode;

import java.util.Arrays;

public class P567 {
	public boolean checkInclusion(String target, String str) {
        if (str.length() < target.length()) {
            return false;
        }
        int[] targetCount = new int[26];
        for (int i = 0; i < target.length(); i++) {
            targetCount[target.charAt(i) - 'a']++;
        }

        int[] windowCount = new int[26];
        for (int i = 0; i < target.length(); i++) {
            windowCount[str.charAt(i) - 'a']++;
        }

        if (Arrays.equals(targetCount, windowCount)) {
            return true;
        }

        for (int i = target.length(); i < str.length(); i++) {
            windowCount[str.charAt(i) - 'a']++;
            windowCount[str.charAt(i - target.length()) - 'a']--;
            if (Arrays.equals(targetCount, windowCount)) {
                return true;
            }
        }
        return false;
    }
}
