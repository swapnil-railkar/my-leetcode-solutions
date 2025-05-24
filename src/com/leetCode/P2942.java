package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P2942 {
	public List<Integer> solution(String[] words, char x) {
        List<Integer> indexes = new ArrayList<>();
        for(int i = 0; i< words.length; i++) {
            if(words[i].lastIndexOf(x) != -1) {
                indexes.add(i);
            }
        }
        return indexes;
    }
}
