package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.leetCode.DsNodes.ListNode;

public class P61 {

	public ListNode solution(ListNode head, int rotation) {
		List<Integer> cache = new ArrayList<>();
		ListNode tempHead = head;
	    
	    while(tempHead != null) {
	    	cache.add(tempHead.val);
	    	tempHead = tempHead.next;
	    }
	    
	    int index = 0;
	    Map<Integer,Integer> indexDataMap = getIndexDataMap(cache, rotation);
	    ListNode rotateHead = head;
	    while(rotateHead != null) {
	    	rotateHead.val = indexDataMap.get(index);
	    	rotateHead = rotateHead.next;
	    	index++;
	    }
	    
		return head;
	}
	
	private Map<Integer,Integer> getIndexDataMap(List<Integer> cache, int rotation) {
		Map<Integer, Integer> indexDataMap = new HashMap<>();
		
		for(int i=0; i< cache.size(); i++) {
			int index = (i + rotation) % cache.size();
			indexDataMap.put(index, cache.get(i));
		}
		
		return indexDataMap;
	}
}
