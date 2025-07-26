package com.leetCode;

import java.util.Arrays;

public class P3480 {
	public long solution(int n, int[][] conflictingPairs) {
		// bMin1 stores the smallest conflicting pair b for each element a
        int[] b1 = new int[n + 1];
        // bMin2 stores the second smallest conflicting pair b for each element a
        int[] b2 = new int[n + 1];
        
        // Initialize arrays with a very large value, indicating no conflicting pair initially
        Arrays.fill(b1, Integer.MAX_VALUE);
        Arrays.fill(b2, Integer.MAX_VALUE);
        
        // Process each conflicting pair
        for (int[] pair : conflictingPairs) {
            int a = Math.min(pair[0], pair[1]); // a is the smaller of the two elements
            int b = Math.max(pair[0], pair[1]); // b is the larger of the two elements
            
            // Update the smallest and second smallest conflicting b for element a
            if (b1[a] > b) {
                b2[a] = b1[a];
                b1[a] = b;
            } else if (b2[a] > b) {
                b2[a] = b;
            }
        }

        // Initialize result variable
        long totValidSubs = 0;
        int b1Index = n; // Start with the last element
        int secondSmallestB = Integer.MAX_VALUE; // Initialize the second smallest b as a large value
        long[] extra = new long[n + 1]; // Tracks additional subarrays that can be gained after deletion

        // Traverse the array from right to left
        for (int i = n; i >= 1; i--) {
            // Update the smallest conflicting b for the current index
            if (b1[b1Index] > b1[i]) {
                secondSmallestB = Math.min(secondSmallestB, b1[b1Index]);
                b1Index = i;
            } else {
                secondSmallestB = Math.min(secondSmallestB, b1[i]);
            }
            
            // Count valid subarrays that start at index i
            totValidSubs += Math.min(b1[b1Index], n + 1) - i;
            
            // Count additional subarrays gained by deleting the conflicting pair involving the current smallest b
            extra[b1Index] += 
                Math.min(Math.min(secondSmallestB, b2[b1Index]), n + 1) -
                Math.min(b1[b1Index], n + 1);
        }

        // Find the maximum additional subarrays gained from deleting any conflicting pair
        long maxExtraSub = 0;
        for (long count : extra) {
            maxExtraSub = Math.max(maxExtraSub, count);
        }

        // Return the total valid subarrays plus the maximum additional subarrays gained by deleting one conflicting pair
        return totValidSubs + maxExtraSub;
    }
}
