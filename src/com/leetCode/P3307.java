package com.leetCode;

public class P3307 {
	public char solution(long k, int[] operations) {
        int shiftCount = 0;
        int operationIndex;

        while (k != 1) {
            // Find the most significant bit position in k (i.e., which operation level we're in)
            operationIndex = 63 - Long.numberOfLeadingZeros(k);

            // If k is exactly a power of 2, go one level down
            if ((1L << operationIndex) == k) {
                operationIndex--;
            }

            // Move k to the corresponding position in the first half
            k = k - (1L << operationIndex);

            // If the operation at this level was a shift (type 1), count the shift
            if (operations[operationIndex] == 1) {
                shiftCount++;
            }
        }

        // Apply all the shifts to the original 'a'
        return (char) ('a' + (shiftCount % 26));
    }
}
