package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class P54 {

    public List<Integer> solution(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();
        int startRow = 0;
        int endRow = matrix.length - 1;
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;

        int totalElements = (endColumn + 1) * (endRow + 1);

        while (spiral.size() < totalElements) {
            if (spiral.size() < totalElements) {
                goRight(spiral, startRow, startColumn, endColumn, matrix);
                startRow++;
            }
            if (spiral.size() < totalElements) {
                goDown(spiral, startRow, endRow, endColumn, matrix);
                endColumn--;
            }
            if (spiral.size() < totalElements) {
                goLeft(spiral, startColumn, endRow, endColumn, matrix);
                endRow--;
            }
            if (spiral.size() < totalElements) {
                goUp(spiral, startRow, startColumn, endRow, matrix);
                startColumn++;
            }
        }

        return spiral;
    }

    private void goUp(List<Integer> spiral, int startRow, int startColumn, int endRow, int[][] matrix) {
        for (int i = endRow; i>= startRow; i--) {
            spiral.add(matrix[i][startColumn]);
        }
    }

    private void goLeft(List<Integer> spiral, int startColumn, int endRow, int endColumn, int[][] matrix) {
        for (int i = endColumn; i>= startColumn; i--) {
            spiral.add(matrix[endRow][i]);
        }
    }

    private void goDown(List<Integer> spiral, int startRow, int endRow, int endColumn, int[][] matrix) {
        for (int i = startRow; i<= endRow; i++) {
            spiral.add(matrix[i][endColumn]);
        }
    }

    private void goRight(List<Integer> spiral, int startRow, int startColumn, int endColumn, int[][] matrix) {
        for (int i = startColumn; i<= endColumn; i++) {
            spiral.add(matrix[startRow][i]);
        }
    }
}
