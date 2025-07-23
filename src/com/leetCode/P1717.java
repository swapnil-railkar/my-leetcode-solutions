package com.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class P1717 {
	public int solution(String s, int x, int y) {
        int gain = 0;
        Map<String, Integer> strGainMap = new HashMap<>();
        strGainMap.put("ab", x);
        strGainMap.put("ba", y);
        String preferred = x > y ? "ab" : "ba";
        int preffGain = strGainMap.get(preferred);
        Stack<Character> stk = new Stack<>();
        for(int i =0; i< s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == 'a' || curr == 'b') {
                if(stk.isEmpty()) {
                    stk.push(curr);
                } else if(Objects.equals(preferred, getString(stk.peek(), curr))) {
                    stk.pop();
                    gain += preffGain;
                } else {
                    stk.push(curr);
                }
            } else {
                if(!stk.isEmpty()) {
                    gain += processStack(stk, strGainMap);
                    stk.clear();
                }
            }
        }
        gain += processStack(stk, strGainMap);
        return gain;
    }

    private int processStack(Stack<Character> stk, Map<String, Integer> strGainMap) {
        Stack<Character> temp = new Stack<>();
        int gain = 0;
        while(!stk.isEmpty()) {
            if(temp.isEmpty() || temp.peek() == stk.peek()) {
                temp.push(stk.pop());
            } else {
                while(!temp.isEmpty() && !stk.isEmpty() && temp.peek() != stk.peek()) {
                    String key = getString(stk.pop(), temp.pop());
                    gain += strGainMap.getOrDefault(key, 0);
                }
            }
        }
        return gain;
    }

    private String getString(char c1, char c2) {
        StringBuilder sb = new StringBuilder();
        sb.append(c1);
        sb.append(c2);
        return sb.toString();
    }
}
