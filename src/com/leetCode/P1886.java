package com.leetCode;

import java.util.Arrays;

public class P1886 {
	public boolean findRotation(int[][] mat, int[][] target) {
        int rows = mat.length;
        int columns = mat[0].length;

        // 0 degree
        if (isEqual(mat, target[0], 0, 0, 0, columns - 1)) {
            int startRow = 0, startCol = 0, endRow = 0, endCol = columns - 1;
            boolean found = true;

            for (int i = 0; i < rows; i++) {
                if (!isEqual(mat, target[i], startRow, startCol, endRow, endCol)) {
                    found = false;
                    break;
                }
                startRow++;
                endRow++;
            }
            if (found)
                return true;
        }

        // 90 degree
        if (isEqual(mat, target[0], 0, columns - 1, rows - 1, columns - 1)) {
            int startRow = 0, startCol = columns - 1, endRow = rows - 1, endCol = columns - 1;
            boolean found = true;

            for (int i = 0; i < rows; i++) {
                if (!isEqual(mat, target[i], startRow, startCol, endRow, endCol)) {
                    found = false;
                    break;
                }
                startCol--;
                endCol--;
            }
            if (found)
                return true;
        }

        // 180 degree
        if (isEqual(mat, target[0], rows - 1, columns - 1, rows - 1, 0)) {
            int startRow = rows - 1, startCol = columns - 1, endRow = rows - 1, endCol = 0;
            boolean found = true;

            for (int i = 0; i < rows; i++) {
                if (!isEqual(mat, target[i], startRow, startCol, endRow, endCol)) {
                    found = false;
                    break;
                }
                startRow--;
                endRow--;
            }
            if (found)
                return true;
        }

        // 270 degree
        if (isEqual(mat, target[0], rows - 1, 0, 0, 0)) {
            int startRow = rows - 1, startCol = 0, endRow = 0, endCol = 0;
            boolean found = true;

            for (int i = 0; i < rows; i++) {
                if (!isEqual(mat, target[i], startRow, startCol, endRow, endCol)) {
                    found = false;
                    break;
                }
                startCol++;
                endCol++;
            }
            if (found)
                return true;
        }

        return false;
    }

    private boolean isEqual(int[][] mat, int[] target, int startRow, int startColumn, int endRow, int endColumn) {
        int[] arr = new int[target.length];
        int j = 0;
        if (startRow == endRow) {
            if (startColumn > endColumn) {
                for (int i = startColumn; i >= endColumn; i--) {
                    arr[j++] = mat[startRow][i];
                }
            } else {
                for (int i = startColumn; i <= endColumn; i++) {
                    arr[j++] = mat[startRow][i];
                }
            }
        } else {
            // startColumn == endColumn
            if (startRow > endRow) {
                for (int i = startRow; i >= endRow; i--) {
                    arr[j++] = mat[i][startColumn];
                }
            } else {
                for (int i = startRow; i <= endRow; i++) {
                    arr[j++] = mat[i][startColumn];
                }
            }
        }
        return Arrays.equals(arr, target);
    }
}
