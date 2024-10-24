package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CountAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] words = {"eat","tea","tan","ate","nat","bat"}; 
        List<List<String>> anagrams = getAnagrams(words);
        System.out.println(anagrams);
	}

	private static List<List<String>> getAnagrams(String[] words) {
		// TODO Auto-generated method stub
		List<List<String>> anagrams = new ArrayList<>();
		List<String> word;
		List<Integer> indexes = new ArrayList<>();
		
		for(int i =0; i< words.length; i++) {
			if(!indexes.contains(i)) {
				indexes.add(i);
				word = new ArrayList<>();
				word = getSimilars(words, words[i], indexes,word, i+1);
				anagrams.add(word);
			}
			
		}
		return anagrams;
	}

	private static List<String> getSimilars(String[] words, String currstring, List<Integer> indexes,List<String> word,int index) {
		
		word.add(currstring);
		for(int i=index; i<words.length; i++) {
			if(words[i].length() == currstring.length() && !indexes.contains(i)) {
				char[] a = currstring.toCharArray();
				char[] b = words[i].toCharArray();
				if(isAnagram(a,b)) {
					word.add(words[i]);
					indexes.add(i);
				}
				
			}
		}
		return word;
	}

	private static boolean isAnagram(char[] ch1, char[] ch2) {
		// TODO Auto-generated method stub
		
		HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0 ; i< ch1.length; i++) {
        	if(map.containsKey(ch1[i])) {
        		map.put(ch1[i], map.get(ch1[i])+1);
        	}else {
        		map.put(ch1[i], 1);
        	}
        }
        
        for(int i=0 ; i< ch2.length ; i++) {
        	if(map.containsKey(ch2[i])) {
        		if(map.get(ch2[i])==1) {
        			map.remove(ch2[i]);
        		}else {
        			map.put(ch2[i], map.get(ch2[i])-1);
        		}
        	}else {
        		return false;
        	}
        }
        
        if(map.size() > 0) {
        	return false;
        }else {
        	return true;
        }
	}

}
