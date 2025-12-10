package com.leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P127 {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.offer(beginWord);
        visited.add(beginWord);
        int level = 1;

        while(!q.isEmpty()) {
            Queue<String> nq = new LinkedList<>();
            while(!q.isEmpty()) {
                String curr = q.poll();
                if(curr.equals(endWord)) {
                    return level;
                }
                for(String word : wordList) {
                    if(!visited.contains(word) && diffByOneChar(word, curr)) {
                        visited.add(word);
                        nq.offer(word);
                    }
                }
            }
            q = nq;
            level++;
        }
        return 0;
    }

    private boolean diffByOneChar(String word, String destination) {
        if (word.length() != destination.length())
            return false;
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != destination.charAt(i)) {
                diff++;
                if (diff > 1)
                    return false;
            }
        }
        return diff <= 1;
    }
}
