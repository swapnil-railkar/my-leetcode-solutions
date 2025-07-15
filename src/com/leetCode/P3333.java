package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P3333 {
	 private static final int MOD = 1000000007;

	    public int possibleStringCount(String word, int k) {
	        int n = word.length();
	        int runLength = 1;
	        List<Integer> runLengths = new ArrayList<>();
	        
	        // Step 1: Group same characters and count run lengths
	        for (int i = 1; i < n; ++i) {
	            if (word.charAt(i) == word.charAt(i - 1)) {
	                runLength++;
	            } else {
	                runLengths.add(runLength);
	                runLength = 1;
	            }
	        }
	        runLengths.add(runLength);

	        // Step 2: Calculate total number of combinations
	        long totalPossibleStrings = 1;
	        for (int count : runLengths) {
	            totalPossibleStrings = (totalPossibleStrings * count) % MOD;
	        }

	        // Step 3: Shortcut if number of runs >= k
	        if (runLengths.size() >= k) {
	            return (int) totalPossibleStrings;
	        }

	        // Step 4: Dynamic Programming to count strings of length < k
	        int[] dp = new int[k];          // dp[j] = ways to form string of length j
	        int[] prefixSum = new int[k];   // prefixSum[j] = sum of dp[0..j]
	        Arrays.fill(prefixSum, 1);      // base case: 1 way to build empty string

	        for (int run : runLengths) {
	            int[] newDp = new int[k];
	            for (int len = 1; len < k; ++len) {
	                newDp[len] = prefixSum[len - 1];
	                if (len - run - 1 >= 0) {
	                    newDp[len] = (newDp[len] - prefixSum[len - run - 1] + MOD) % MOD;
	                }
	            }

	            // Update prefixSum for next iteration
	            int[] newPrefixSum = new int[k];
	            newPrefixSum[0] = newDp[0];
	            for (int len = 1; len < k; ++len) {
	                newPrefixSum[len] = (newPrefixSum[len - 1] + newDp[len]) % MOD;
	            }
	            dp = newDp;
	            prefixSum = newPrefixSum;
	        }

	        // Final result: total - number of short strings
	        return (int) ((totalPossibleStrings - prefixSum[k - 1] + MOD) % MOD);
	    }
}
