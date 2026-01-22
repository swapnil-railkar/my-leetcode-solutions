package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P3507 {
	public int solution(int[] nums) {
		List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        int op = 0;
        while (!isSorted(temp)) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < temp.size() - 1; i++) {
                int pairSum = temp.get(i) + temp.get(i + 1);
                if (pairSum < min) {
                    min = pairSum;
                    minIndex = i;
                }
            }

            temp.set(minIndex, min);
            temp.remove(minIndex + 1);
            op++;
        }
        return op;
    }

    private boolean isSorted(List<Integer> temp) {
        for(int i = 1; i< temp.size(); i++) {
            if(temp.get(i - 1) > temp.get(i)) {
                return false;
            }
        }
        return true;
    }
}
