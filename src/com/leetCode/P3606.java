package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P3606 {
	public List<String> solution(String[] codes, String[] businessLine, boolean[] isActive) {
        Map<String, Integer> businessLinePriority = new HashMap<>();
        businessLinePriority.put("electronics", 0);
        businessLinePriority.put("grocery", 1);
        businessLinePriority.put("pharmacy", 2);
        businessLinePriority.put("restaurant", 3);
        PriorityQueue<Coupon> pq = new PriorityQueue<>((a, b) -> {
            if(a.priority == b.priority) {
                return a.code.compareTo(b.code);
            }
            return Integer.compare(a.priority, b.priority);
        });

        for(int i = 0; i< codes.length; i++) {
            if(isActive[i] && isValidCode(codes[i]) && isValidBusinessLine(businessLine[i])) {
                int priority = businessLinePriority.get(businessLine[i]);
                pq.offer(new Coupon(priority, codes[i]));
            }
        }

        List<String> answer = new ArrayList<>();
        while(!pq.isEmpty()) {
            Coupon coup = pq.poll();
            answer.add(coup.code);
        }
        return answer;
    }

    private boolean isValidCode(String code) {
        for(char ch : code.toCharArray()) {
            if(Character.isLetterOrDigit(ch) || ch == '_') {
                continue;
            } else {
                return false;
            }  
        }
        return !code.isBlank();
    }

    private boolean isValidBusinessLine(String line) {
        switch(line) {
            case "electronics":
            case "grocery":
            case "pharmacy":
            case "restaurant": return true;
            default: return false;
        }
    }

    private static class Coupon{ 
        int priority;
        String code;

        Coupon(int priority, String code) {
            this.priority = priority;
            this.code = code;
        }
    }
}
