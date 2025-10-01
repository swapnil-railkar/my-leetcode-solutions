package com.leetCode;

public class P3698 {
	public long solution(int[] nums) {
		int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        // validate left subarray.
        for (int i = 1; i < maxIndex; i++) {
            if (nums[i] <= nums[i - 1]) {
                return -1;
            }
        }

        // validate right subarray.
        for (int i = maxIndex + 1; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                return -1;
            }
        }

        long leftSum = 0;
        long rightSum = 0;
        if (maxIndex < nums.length - 1 && nums[maxIndex] == nums[maxIndex + 1]) {
            leftSum = getSum(nums, 0, maxIndex);
            rightSum = getSum(nums, maxIndex + 1, nums.length - 1);
        } else {
            leftSum = getSum(nums, 0, maxIndex - 1);
            rightSum = getSum(nums, maxIndex + 1, nums.length - 1);

            if (leftSum < rightSum) {
                leftSum += nums[maxIndex];
            } else {
                rightSum += nums[maxIndex];
            }
        }
        return Math.abs(leftSum - rightSum);
	}

    private long getSum(int[] nums, int start, int end) {
        long sum = 0;
        for(int i = start; i<= end; i++) {
            sum += nums[i];
        }
        return sum;
    }
}
