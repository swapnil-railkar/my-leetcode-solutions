package com.leetCode;

import java.util.Set;
import java.util.HashSet;

public class P2657 {
	
	public int[] solution(int[] A, int[] B) {
        Set<Integer> a_set = new HashSet<>();
        Set<Integer> b_set = new HashSet<>();
        int[] count = new int[A.length];
        for(int i = 0; i< A.length; i++) {
            a_set.add(A[i]);
            b_set.add(B[i]);
            Set<Integer> temp = new HashSet<>(a_set);
            temp.retainAll(b_set);
            count[i] = temp.size(); 
        }

        return count;
    }
}
