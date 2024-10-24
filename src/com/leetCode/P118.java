package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int h = 1;
        List<List<Integer>> tri= getPascal(h);
        System.out.println(tri);
	}

	private static List<List<Integer>> getPascal(int h) {
		// TODO Auto-generated method stub
		List<Integer> floor , oldFloor;
		List<List<Integer>> tri = new ArrayList<>();
		
	    floor = new ArrayList<>();
	    floor.add(1);
	    tri.add(floor);
			
		 h-=1;
		    
		 for(int i=0 ; i< h; i++) {
		     oldFloor = floor;
		     floor = new ArrayList<>();
		     for(int j=0; j<=oldFloor.size(); j++) {
		    	 if( j== 0 || j == oldFloor.size()) {
		    		floor.add(1);
		    	 }else {
		    		int sum = oldFloor.get(j-1) + oldFloor.get(j);
		    		floor.add(sum);
		    	}
		    }
		    tri.add(floor);
		}
		
		return tri;
	}

}
