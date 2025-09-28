package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P131 {
	public List<List<String>> solution(String s) {
        List<List<String>> ans = new ArrayList<>();
        getAllPartitions(s, new ArrayList<>(), ans);
        return ans;
    }

    void getAllPartitions(String str, List<String> partition, List<List<String>> ans) {
        if(str.isEmpty()) {
            ans.add(new ArrayList<>(partition));
            return;
        }
        for(int i = 0; i< str.length(); i++) {
            String sub = str.substring(0, i + 1);
            if(isPallindrome(sub)) {
                partition.add(sub);
                getAllPartitions(str.substring(i + 1), partition, ans);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPallindrome(String str) {
        for(int i = 0, j = str.length() - 1; i <= j; i++, j--) {
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
