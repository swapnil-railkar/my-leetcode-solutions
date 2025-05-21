package com.leetCode;

public class P79 {

	public boolean solution(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(board[row][column] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][columns];
                    visited[row][column] = true;
                    if (exist(row, column, board, visited, word, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

	private boolean exist(int row, int column, char[][] board, boolean[][] visited, String word, int index) {
        if(index == word.length()) {
            return true;
        }
        char nextChar = word.charAt(index);
        visited[row][column] = true;
        boolean leftFound = false, rightFound = false, upFound = false, downFound = false;
        // up
        if(row > 0 && !visited[row - 1][column] && board[row - 1][column] == nextChar) {
             if(exist(row - 1, column, board, visited, word, index + 1)) {
                 upFound = true;
             }
        }
        // down
        if(row < board.length - 1 && !visited[row + 1][column] && board[row + 1][column] == nextChar) {
            if(exist(row + 1, column, board, visited, word, index + 1)) {
                downFound = true;
            }
        }
        // left
        if(column > 0 && !visited[row][column - 1] && board[row][column - 1] == nextChar) {
            if(exist(row, column - 1, board, visited, word, index + 1)) {
                leftFound = true;
            }
        }
        // right
        if(column < board[0].length - 1 && !visited[row][column + 1] && board[row][column + 1] == nextChar) {
            if(exist(row, column + 1, board, visited, word, index + 1)) {
                rightFound = true;
            }
        }
        visited[row][column] = false;
        return upFound || downFound || leftFound || rightFound;
    }
}
