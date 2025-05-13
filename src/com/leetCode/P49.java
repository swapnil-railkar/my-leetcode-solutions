package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P49 {

	public List<List<String>> solution(String[] strs) {
        Map<String, List<String>> keyAnagramMap = new HashMap<>();
        for(String str : strs) {
        	String key = getKey(str);
            if(keyAnagramMap.containsKey(key)) {
            	keyAnagramMap.get(key).add(str);
            } else {
            	List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                keyAnagramMap.put(key, anagrams);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key : keyAnagramMap.keySet()) {
            ans.add(keyAnagramMap.get(key));
        }
        return ans;
    }
	
    private String getKey(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
