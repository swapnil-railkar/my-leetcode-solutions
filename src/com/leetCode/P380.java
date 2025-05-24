package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P380 {
	List<Integer> list = null;
    Map<Integer, Integer> valueIndexMap = null;
    
    public P380() {
        list = new ArrayList<>();
        valueIndexMap = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(valueIndexMap.containsKey(val)) {
            return false;
        }
        list.add(val);
        valueIndexMap.put(val, list.size() - 1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valueIndexMap.containsKey(val)) {
            return false;
        }
        int index = valueIndexMap.get(val);
        int lastVal = list.get(list.size() - 1);
        
        list.set(index, lastVal);
        valueIndexMap.put(lastVal, index);

        valueIndexMap.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = (int)(Math.random() * list.size());
        return list.get(randomIndex);
    }
}
