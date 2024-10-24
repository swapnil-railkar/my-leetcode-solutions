package com.leetCode.Arrays;

import java.util.Objects;

public class P74 {

    public boolean solution(int[][] matrix, int key) {
        Integer row = getRowIndex(matrix, key);
        if (Objects.isNull(row)) {
            return false;
        }
        Integer index = getKeyIndex(matrix[row], key);
        return !Objects.isNull(index);
    }

    private Integer getKeyIndex(int[] row, int key) {
        int startIndex = 0;
        int endIndex = row.length - 1;

        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (row[mid] == key) {
                return mid;
            } else if (key < row[mid]) {
                endIndex = mid - 1;
            } else if (key > row[mid]) {
                startIndex = mid + 1;
            }
        }

        return null;
    }

    private Integer getRowIndex(int[][] matrix, int key) {
        int startIndex = 0;
        int endIndex = matrix.length - 1;

        int length = matrix[0].length - 1;

        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;
            if (matrix[mid][0] <= key && matrix[mid][length] >= key) {
                return mid;
            }else if (key < matrix[mid][0]) {
                endIndex = mid - 1;
            } else if (key > matrix[mid][0]) {
                startIndex = mid + 1;
            }
        }

        return null;
    }
}
