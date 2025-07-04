package com.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class P59 {
	public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n * n; i++) {
            q.add(i);
        }
        int row = 0;
        int column = 0;
        int endRow = n - 1;
        int endColumn = n - 1;
        while (!q.isEmpty()) {
            if (!q.isEmpty()) {
                left(row, column, visited, q, arr);
                row++;
            }
            if (!q.isEmpty()) {
                down(row, endColumn, visited, q, arr);
                endColumn--;
            }
            if (!q.isEmpty()) {
                right(endRow, endColumn, visited, q, arr);
                endRow--;
            }
            if (!q.isEmpty()) {
                up(endRow, column, visited, q, arr);
                column++;
            }
        }
        return arr;
    }

    private void left(int row, int column, boolean[][] visited, Queue<Integer> q, int[][] arr) {
        while (column < arr[0].length && !visited[row][column]) {
            arr[row][column] = q.remove();
            visited[row][column] = true;
            column++;
        }
    }

    private void right(int row, int column, boolean[][] visited, Queue<Integer> q, int[][] arr) {
        while (column >= 0 && !visited[row][column]) {
            arr[row][column] = q.remove();
            visited[row][column] = true;
            column--;
        }
    }

    private void up(int row, int column, boolean[][] visited, Queue<Integer> q, int[][] arr) {
        while (row >= 0 && !visited[row][column]) {
            arr[row][column] = q.remove();
            visited[row][column] = true;
            row--;
        }
    }

    private void down(int row, int column, boolean[][] visited, Queue<Integer> q, int[][] arr) {
        while (row < arr.length && !visited[row][column]) {
            arr[row][column] = q.remove();
            visited[row][column] = true;
            row++;
        }
    }
}
