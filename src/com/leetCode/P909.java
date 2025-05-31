package com.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P909 {
	public int solution(int[][] board) {
        Map<Integer, List<Integer>> numIndexMap = new HashMap<>();
        boolean forward = true;
        int num = 1;
        for(int i = board.length - 1; i>= 0; i--) {
            if(forward) {
                for(int j =0; j< board[0].length; j++) {
                    numIndexMap.put(num, List.of(i, j));
                    num++;
                }
            } else {
                for(int j =board[0].length - 1; j>=0; j--) {
                    numIndexMap.put(num, List.of(i, j));
                    num++;
                }
            }
            forward = !forward;
        }
        int[][] dist = new int[board.length][board[0].length];
        for(int i = 0; i< dist.length; i++) {
            Arrays.fill(dist[i], num);
        }
        dist[dist.length - 1][0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        bfs(q, dist, board, numIndexMap, num);
        int minDist = dist[numIndexMap.get(num - 1).get(0)][numIndexMap.get(num - 1).get(1)];
        return minDist == num ? -1 : minDist;
    }

    private void bfs(Queue<Integer> q, int[][] dist, int[][] board, Map<Integer, List<Integer>> numIndexMap, int maxNum) {
        while(!q.isEmpty()) {
            int num = q.remove();
            int currDist = dist[numIndexMap.get(num).get(0)][numIndexMap.get(num).get(1)];
            for(int i =1; i<= 6; i++) {
                if(num + i < maxNum) {
                    int row = numIndexMap.get(num + i).get(0);
                    int column = numIndexMap.get(num + i).get(1);
                    if(board[row][column] != -1) {
                        int toRow =  numIndexMap.get(board[row][column]).get(0);
                        int toColumn =  numIndexMap.get(board[row][column]).get(1);
                        if(dist[toRow][toColumn] > currDist + 1) {
                            dist[toRow][toColumn] = currDist + 1;
                            q.add(board[row][column]);
                        }
                    } else if(dist[row][column] > currDist + 1){
                        dist[row][column] = currDist + 1;
                        q.add(num + i);
                    }
                }
            }
        }
    }
}
