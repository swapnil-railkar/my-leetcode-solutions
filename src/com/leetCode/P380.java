package com.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P380 {
	Set<Integer> set = null;
    List<Integer> randomizedSet = null;
    
    public P380() {
        set = new HashSet<>();
        randomizedSet = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(set.contains(val)) {
            return false;
        }
        set.add(val);
        randomizedSet.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val)) {
            return false;
        }
        set.remove(val);
        Integer wrapper = Integer.valueOf(val);
        randomizedSet.remove(wrapper);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = (int)(Math.random() * randomizedSet.size());
        return randomizedSet.get(randomIndex);
    }
}
