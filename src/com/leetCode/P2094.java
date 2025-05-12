package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P2094 {

	public int[] solution(int[] digits) {
        Arrays.sort(digits);
        Set<Integer> cache = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 100; i<= 999; i++) {
            if(i %2 == 0 && canCreate(i, digits, cache)) {
                answer.add(i);
            }
        }
        return convertToArray(answer);
    }

    private boolean canCreate(int num, int[] digits, Set<Integer> cache) {
        int[] temp = new int[3];
        String numStr = Integer.toString(num); 
        temp[0] = Character.getNumericValue(numStr.charAt(0));
        temp[1] = Character.getNumericValue(numStr.charAt(1));
        temp[2] = Character.getNumericValue(numStr.charAt(2));
        Arrays.sort(temp);
        int sortedNum = temp[0] * 100 + temp[1] * 10 + temp[2];
        if(cache.contains(sortedNum)) {
            return true;
        } else {
            int index = 0;
            for(int n : digits) {
                if(index >= 3) {
                    break;
                } else if(temp[index] == n) {
                    index++;
                }
            }
            if(index == 3) {
                cache.add(sortedNum);
                return true;
            }
            return false;
        }
    }

    private int[] convertToArray(List<Integer> list) {
        int[] ans = new int[list.size()];
        for(int i = 0; i< ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
