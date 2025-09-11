package com.leetCode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class P2785 {
	public String solution(String str) {
        Set<Character> vowels = Set.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        PriorityQueue<Character> pq = new PriorityQueue<>();
        Set<Integer> vowIndex = new HashSet<>();
        for(int i = 0; i< str.length(); i++) {
            char curr = str.charAt(i);
            if(vowels.contains(curr)) {
                pq.add(curr);
                vowIndex.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< str.length(); i++) {
            if(vowIndex.contains(i)) {
                sb.append(pq.poll());
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
