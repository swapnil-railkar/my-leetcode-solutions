package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P2900 {
	public List<String> solution(String[] words, int[] groups) {
		int prev = groups[0];
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1; i< groups.length; i++) {
            if(prev != groups[i]) {
                ans.add(words[i]);
                prev = groups[i];
            }
        }
        return ans;
    }
}
