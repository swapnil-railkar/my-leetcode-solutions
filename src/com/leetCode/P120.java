package com.leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P120 {

	public int solution(List<List<Integer>> triangle) {
		List<List<Integer>> sum = new ArrayList<>();

		// populate first row.
		List<Integer> firstRow = new ArrayList<>(1);
		firstRow.add(triangle.get(0).get(0));
		sum.add(firstRow);

		// populate height and slant
		for(int i = 1; i< triangle.size(); i++) {
			List<Integer> row = new ArrayList<>(Collections.nCopies(triangle.get(i).size(), 0));
			int hieghtTotal = triangle.get(i).get(0) + sum.get(i-1).get(0);
			int slantTotal = triangle.get(i).get(triangle.get(i).size() - 1) 
					+  sum.get(i - 1).get(sum.get(i-1).size() - 1);
			row.set(row.size() - 1, slantTotal);
			row.set(0, hieghtTotal);
			sum.add(row);
		}

		// populate rem traingle sum
		for(int i =2; i< triangle.size(); i++) {
			for(int j = 1; j< triangle.get(i).size() - 1; j++) {
				int total = triangle.get(i).get(j) + Math.min(sum.get(i-1).get(j), sum.get(i - 1).get(j - 1));
				sum.get(i).set(j, total);
			}
		}

		return getMinNumOfLastRow(sum.get(sum.size() - 1));
	}

	private int getMinNumOfLastRow(List<Integer> list) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		for(int num : list) {
			min = Math.min(num, min);
		}
		return min;
	}
}