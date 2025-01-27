package com.leetCode;

import java.util.List;
import java.util.ArrayList;

public class P1462 {
	
	public List<Boolean> solution(int numCourses, int[][] prerequisites, int[][] queries) {
		List<Boolean> isReq = new ArrayList<>();
        boolean[][] isPreReq = new boolean[numCourses][numCourses];

        // init preRqMap
        for (int[] entry : prerequisites) {
            isPreReq[entry[0]][entry[1]] = true;
        }

        // loop to mark indirect dependency
        // for each intermediate node k
        for (int k = 0; k < numCourses; k++) {
        	// for each pair of node i,j if there is path via k, mark it as true
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    isPreReq[i][j] = isPreReq[i][j] || (isPreReq[i][k] && isPreReq[k][j]);
                }
            }
        }

        for (int[] query : queries) {
            isReq.add(isPreReq[query[0]][query[1]]);
        }

        return isReq;
    }

}
