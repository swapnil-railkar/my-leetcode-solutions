package com.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class P981 {
	Map<String, TreeMap<Integer, String>> map = null;
    public P981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (map != null) {
            TreeMap<Integer, String> tsVMap = map.getOrDefault(key, new TreeMap<>());
            tsVMap.put(timestamp, value);
            map.put(key, tsVMap);    
        }
    }

    public String get(String key, int timestamp) {
        if(map.containsKey(key)) {
            if(map.get(key).containsKey(timestamp)) {
                return map.get(key).get(timestamp);
            } else {
                Integer floorKey = map.get(key).floorKey(timestamp);
                return floorKey == null ? "" : map.get(key).get(floorKey);
            }
        }
        return "";
    }
}
