package com.leetCode;

public class P3201 {
	public int maximumLength(int[] nums) {
        int even = 0, odd = 0, evenOdd = 0, oddEven = 0;
        boolean evenOddFlag = false, oddEvenFlag = false;
        int max = 0;

        for(int num : nums) {
            if(num % 2 == 0) {
                even++;
                max = Math.max(max, even);
                if(!evenOddFlag) {
                    evenOdd++;
                    max = Math.max(max, evenOdd);
                    evenOddFlag = true;
                }
                if(oddEvenFlag) {
                    oddEven++;
                    max = Math.max(max, oddEven);
                    oddEvenFlag = false;
                }
            } else {
                odd++;
                max = Math.max(max, odd);
                if(!oddEvenFlag) {
                    oddEven++;
                    max = Math.max(max, oddEven);
                    oddEvenFlag = true;
                }
                if(evenOddFlag) {
                    evenOdd++;
                    max = Math.max(max, evenOdd);
                    evenOddFlag = false;
                }
            }
        }
        return max;
    }
}
