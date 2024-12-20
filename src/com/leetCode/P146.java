package com.leetCode;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class P146 {
	
	Map<Integer, Integer> cache = new HashMap<>();
	int capacity = -1;
	
	Set<Integer> keySet = new LinkedHashSet<>();
	
	public P146(int capacity) {
		this.capacity = capacity;
    }
    
    public int get(int key) {
    	if(cache.containsKey(key)) {
    		if(this.keySet.contains(key)) {
    			Integer keyObj = key;
    			this.keySet.remove(keyObj);
    		}
    		this.keySet.add(key);
    		return cache.get(key);
    	}
        return -1;
    }
    
    public void put(int key, int value) {
    	if(capacity == -1) {
    		// obj is not initialized yet
    		return;
    	}
        if(cache.size() == capacity && !cache.containsKey(key)) {
        	Integer oldestKey = this.keySet.iterator().next();
        	cache.remove(oldestKey);
        	this.keySet.remove(oldestKey);
        }
        cache.put(key, value);
        if(this.keySet.contains(key)) {
			Integer keyObj = key;
			this.keySet.remove(keyObj);
		}
        this.keySet.add(key);
    }
}
