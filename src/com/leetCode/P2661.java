package com.leetCode;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

public class P2661 {
	
	public int solution(int[] arr, int[][] mat) {
		int rows = mat.length;
        int columns = mat[0].length;
        Map<Integer, List<Integer>> valueIndexMap = new HashMap<>();
        int[] rowsCount = new int[rows];
        int[] columnsCount = new int[columns];

        for(int row = 0; row< rows; row++) {
            for(int column = 0; column< columns; column++) {
                valueIndexMap.put(mat[row][column], List.of(row, column));
            }
        }

        for(int i = 0; i< arr.length; i++) {
            int row = valueIndexMap.get(arr[i]).get(0);
            rowsCount[row] -= 1;
            if(rowsCount[row] == columns * -1) {
                return i;
            }
            int column = valueIndexMap.get(arr[i]).get(1);
            columnsCount[column] -= 1;
            if(columnsCount[column] == rows * -1) {
                return i;
            }
        }

        // ideally flow should never reach here.
        return -1;
	}
}
