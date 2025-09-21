package com.leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class P3508 {
	Queue<Packet> q = new LinkedList<>();
    Map<Integer, Set<Packet>> map = new HashMap<>(); 
    int limit = 0;
    public P3508(int memoryLimit) {
        limit = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if(map.containsKey(timestamp) && map.get(timestamp).contains(packet)) {
            return false;
        }
        if(q.size() == limit) {
            Packet p = q.remove();
            map.get(p.timestamp).remove(p);
        }
        
        q.add(packet);
        if(map.containsKey(timestamp)) {
            map.get(timestamp).add(packet);
        } else {
            Set<Packet> set = new HashSet<>();
            set.add(packet);
            map.put(timestamp, set);
        }
        return true;
    }
    
    public int[] forwardPacket() {
        if(q.isEmpty()) {
            return new int[] {};
        }
        Packet p = q.remove();
        map.get(p.timestamp).remove(p);
        return new int[] {p.source, p.destination, p.timestamp};
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        int count = 0;
        for(int i = startTime; i<= endTime; i++) {
            if(map.containsKey(i)) {
                for(Packet p : map.get(i)) {
                    if(p.destination == destination) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private static class Packet{
        int source;
        int destination;
        int timestamp;
        Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }
    }
}
