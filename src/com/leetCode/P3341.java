package com.leetCode;

import java.util.PriorityQueue;

public class P3341 {
	
	public int solution(int[][] matrix) {
		int[][] processed = new int[matrix.length][matrix[0].length];
        matrix[0][0] = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[0].length; column++) {
                processed[row][column] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Wrapper> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.add(new Wrapper(matrix[0][0], 0, 0));
        processMatrix(matrix, processed, pq);
        return processed[matrix.length - 1][matrix[0].length - 1];
    }

	private void processMatrix(int[][] matrix, int[][] processed, PriorityQueue<Wrapper> pq) {
        if (pq.isEmpty()) {
            return;
        }
        Wrapper currNode = pq.remove();
        int row = currNode.row;
        int column = currNode.column;
        int time = currNode.time;
        
        // new min processed value found.
        if (processed[row][column] > time) {
            // update neighbors with current processed value.
            processed[row][column] = time;
            if (isValidPosition(row + 1, column, matrix)) {
                updateQ(time, matrix, processed, pq, row + 1, column);
            }
            if (isValidPosition(row - 1, column, matrix)) {
                updateQ(time, matrix, processed, pq, row - 1, column);
            }
            if (isValidPosition(row, column + 1, matrix)) {
                updateQ(time, matrix, processed, pq, row, column + 1);
            }
            if (isValidPosition(row, column - 1, matrix)) {
                updateQ(time, matrix, processed, pq, row, column - 1);
            }
        }
        processMatrix(matrix, processed, pq);
    }

    private void updateQ(int currentTime, int[][] matrix, int[][] processed, PriorityQueue<Wrapper> pq, int row,
            int column) {
        int nextTime = Math.max(currentTime + 1, matrix[row][column] + 1);
        if (nextTime < processed[row][column]) {
            pq.add(new Wrapper(nextTime, row, column));
        }
    }

    private boolean isValidPosition(int row, int column, int[][] matrix) {
        return (row >= 0 && row < matrix.length)
                && (column >= 0 && column < matrix[0].length);
    }

    private static class Wrapper {
        int time;
        int row;
        int column;

        Wrapper(int time, int row, int column) {
            this.time = time;
            this.row = row;
            this.column = column;
        }
    }
}
