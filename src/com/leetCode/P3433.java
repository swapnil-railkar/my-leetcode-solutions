package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class P3433 {
	public int[] solution(int numberOfUsers, List<List<String>> events) {
        Set<Integer> onlineUsers = new HashSet<>();
        for(int i =0; i< numberOfUsers; i++) {
            onlineUsers.add(i);
        }

        Map<Integer, Integer> userOfflineAtMap = new HashMap<>();
        int[] userMentionCount = new int[numberOfUsers];

        PriorityQueue<Message> pq = new PriorityQueue<>((a, b) -> {
            if(a.time == b.time) {
                return Integer.compare(a.priority, b.priority);
            }
            return Integer.compare(a.time, b.time);
        });
        for(List<String> event : events) {
            int priority = 1;
            if(event.get(0).equals("OFFLINE")) {
                priority = 0;
            }
            pq.add(new Message(priority, event.get(0), Integer.parseInt(event.get(1)), event.get(2)));
        }

        while(!pq.isEmpty()) {
            Message curr = pq.poll();
            int time = curr.time;
            Set<Integer> idsToRemove = new HashSet<>(); 
            for(int key : userOfflineAtMap.keySet()) {
                if(time >= userOfflineAtMap.get(key) + 60) {
                    onlineUsers.add(key);
                    idsToRemove.add(key);
                }
            }
            for(int key : idsToRemove) {
                userOfflineAtMap.remove(key);
            }
            if(curr.type.equals("MESSAGE")) {
                if(curr.mentions.equals("ALL")) {
                    for(int i = 0; i< numberOfUsers; i++) {
                        userMentionCount[i] += 1;
                    }
                } else if(curr.mentions.equals("HERE")) {
                    for(int user : onlineUsers) {
                        userMentionCount[user] += 1;
                    }
                } else {
                    int[] mentions = getMentions(curr.mentions);
                    for(int user : mentions) {
                        userMentionCount[user] += 1;
                    }
                }
            }
            if(curr.type.equals("OFFLINE")) {
                int id = Integer.parseInt(curr.mentions);
                onlineUsers.remove(id);
                userOfflineAtMap.put(id, time);
            }
        }
        return userMentionCount;
    }

    private int[] getMentions(String mentions) {
        String[] arr = mentions.split("\\s+");
        int[] ids = new int[arr.length];
        for(int i =0; i< arr.length; i++) {
            StringBuilder sb = new StringBuilder(arr[i]);
            sb.delete(0, 2);
            ids[i] = Integer.parseInt(sb.toString());
        }
        return ids;
    }

    private static class Message {
        int priority;
        String type;
        int time;
        String mentions;

        Message(int priority, String type, int time, String mentions) {
            this.priority = priority;
            this.type = type;
            this.time = time;
            this.mentions = mentions;
        }
    }
}
