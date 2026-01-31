package com.leetCode;

public class P744 {
	public char solution(char[] letters, char target) {
        int index = getCharIndex(letters, target);
        return index == -1 ? letters[0] : letters[index];
    }

    private int getCharIndex(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        int index = -1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(letters[mid] > target) {
                index = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }
}
