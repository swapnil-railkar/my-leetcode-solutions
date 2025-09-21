package com.leetCode;

import java.util.Arrays;

public class P16 {
	public int solution(int[] nums, int target) {
		Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                int[] sums = new int[3];
                sums[0] = getSum(nums, 0, i - 1, sum, target);
                sums[1] = getSum(nums, i + 1, j - 1, sum, target);
                sums[2] = getSum(nums, j + 1, nums.length - 1, sum, target);

                for(int s : sums) {
                    int currDiff = Math.abs(target - s);
                    int closestDiff = Math.abs(target - closest);
                    if(currDiff < closestDiff) {
                        closest = s;
                    }
                }

            }
        }
        return closest;
    }

    private int getSum(int[] nums, int start, int end, int sum, int target) {
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            int tot = nums[mid] + sum;
            int diff = Math.abs(target - tot);
            if (diff < minDiff) {
                minDiff = diff;
                minSum = tot;
            }
            if (diff == 0) {
                return tot;
            }

            int leftTot = (mid > 0) ? nums[mid - 1] + sum : Integer.MAX_VALUE; 
            int rightTot = (mid < nums.length - 1) ? nums[mid + 1] + sum : Integer.MAX_VALUE; 

            if (leftTot == Integer.MAX_VALUE && rightTot == Integer.MAX_VALUE) {
                return minSum;
            }

            if (leftTot != Integer.MAX_VALUE && Math.abs(target - leftTot) < diff) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return minSum;
    }
}
