package com.leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P542 {
	public int[][] solution(int[][] mat) {
		int rows = mat.length;
        int columns = mat[0].length;
        int[][] dist = new int[rows][columns];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        Queue<Wrapper> q = new LinkedList<>();
        for(int row = 0; row< rows; row++) {
            for(int column = 0; column< columns; column++) {
                if(mat[row][column] == 0) {
                    dist[row][column] = 0;
                    q.add(new Wrapper(row, column));
                }
            }
        }
        updateDist(dist, q);
        return dist;
    }

    private void updateDist(int[][] dist, Queue<Wrapper> q) {
        while(!q.isEmpty()) {
            Wrapper wrapper = q.remove();
            int row = wrapper.row;
            int column = wrapper.column;
            // up
            if(row > 0 && dist[row - 1][column] > dist[row][column] + 1) {
                dist[row - 1][column] = dist[row][column] + 1;
                q.add(new Wrapper(row - 1, column));
            }
            // down
            if(row < dist.length - 1 && dist[row + 1][column] > dist[row][column] + 1) {
                dist[row + 1][column] = dist[row][column] + 1;
                q.add(new Wrapper(row - 1, column));
            }
            // left
            if(column > 0 && dist[row][column - 1] > dist[row][column] + 1) {
                dist[row][column - 1] = dist[row][column] + 1;
                q.add(new Wrapper(row, column - 1));
            }
            // right
            if(column < dist[0].length && dist[row][column + 1] > dist[row][column] + 1) {
                dist[row][column + 1] = dist[row][column] + 1;
                q.add(new Wrapper(row, column + 1));
            }
        }
    }

    private static class Wrapper {
        int row;
        int column;

        Wrapper(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
