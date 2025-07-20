package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1233 {
	public List<String> solution(String[] folders) {
        Arrays.sort(folders);
        List<String> ans = new ArrayList<>();
        String prev = "";
        for(String folder : folders) {
            if(prev.isEmpty() || !folder.startsWith(prev) || folder.charAt(prev.length()) != '/') {
                ans.add(folder);
                prev = folder;
            }
        }
        return ans;
    }
}
