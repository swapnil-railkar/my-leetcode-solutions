package com.leetCode;

import java.util.Set;
import java.util.HashSet;

public class P73 {
	
	public void solution(int[][] matrix) {
		// rows to paint 0
		Set<Integer> rows = new HashSet<>();
		// columns to paint 0
		Set<Integer> columns = new HashSet<>();

		// find out rows and columns to paint 0
		for(int row = 0; row< matrix.length; row++) {
			for(int column = 0; column < matrix[row].length; column++) {
				if(matrix[row][column] == 0) {
					rows.add(row);
					columns.add(column);
				}
			}
		}
		
		// colour identified rows 0
		for(int row: rows) {
		    for(int i =0; i< matrix[row].length; i++) {
		    	matrix[row][i] = 0;
		    }
		}
		
		// colour identified columns 0
		for(int column: columns) {
		    for(int i =0; i< matrix.length; i++) {
		    	matrix[i][column] = 0;
		    }
		}

	}
}
