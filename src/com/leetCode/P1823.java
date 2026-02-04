package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P1823 {
	public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int currIndex = 0;
        for(int i = 1; i<= n; i++) {
            list.add(i);
        }
        while(list.size() > 1) {
            int indexToRemove = (currIndex + k - 1) % list.size();
            list.remove(indexToRemove);
            currIndex = indexToRemove;
        }
        return list.get(0);
    }
}
