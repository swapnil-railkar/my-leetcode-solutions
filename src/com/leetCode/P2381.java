package com.leetCode;


public class P2381 {
	
	// watch for explanation : https://www.youtube.com/watch?v=eEUjVY7wK3k
	public String solution(String str, int[][] shifts) {
		int n = str.length();
        int[] diff = new int[n + 1];

        // Apply each shift to the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            // Increment or decrement the shift value
            diff[start] += direction == 1 ? 1 : -1;
            diff[end + 1] -= direction == 1 ? 1 : -1;
        }

        // Compute cumulative shifts
        int[] cumulative = new int[n];
        int shiftValue = 0;
        for (int i = 0; i < n; i++) {
            shiftValue += diff[i];
            cumulative[i] = shiftValue;
        }

        // Build the resulting string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int originalChar = str.charAt(i) - 'a';
            int shiftedChar = (originalChar + cumulative[i]) % 26;
            if (shiftedChar < 0) {
                shiftedChar += 26; // Handle negative shifts
            }
            result.append((char) (shiftedChar + 'a'));
        }

        return result.toString();
	}

}
