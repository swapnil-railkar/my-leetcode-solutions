package com.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class P767 {
	public String solution(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Wrapper> max = new PriorityQueue<>((a, b) -> Integer.compare(b.count, a.count));
        for (char key : charCountMap.keySet()) {
            max.add(new Wrapper(key, charCountMap.get(key)));
        }
        char[] ans = new char[s.length()];
        Arrays.fill(ans, '1');
        Wrapper w = max.poll();
        ans[0] = w.c;
        if (w.count > 1) {
            max.add(new Wrapper(w.c, w.count - 1));
        }
        while (!max.isEmpty()) {
            Wrapper wrapper = max.poll();
            char curr = wrapper.c;
            int count = wrapper.count;
            int i = 1;
            boolean found = false;
            while (i < ans.length && !found) {
                if(ans[i - 1] != curr && ans[i] == '1') {
                    found = true;
                } else {
                    i++;
                }
            }
            if (i == ans.length) {
                return "";
            }
            ans[i] = curr;
            if (count - 1 > 0) {
                max.add(new Wrapper(curr, count - 1));
            }
        }

        return new String(ans);
    }

    private static class Wrapper {
        char c;
        int count;

        Wrapper(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
}
