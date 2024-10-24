package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P79 {

    public boolean solution(char[][] board, String word) {
        return findWord(board, word);
    }
    private boolean findWord(char[][] board, String word) {
        for (int i = 0; i< board.length; i++) {
            for (int j = 0; j< board[0].length; j++) {
                if (word.contains(String.valueOf(board[i][j]))) {
                    if (wordFound(board, i, j, word, new Stack<>(), word.charAt(word.length() - 1))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // TODO : Too slow
    private boolean wordFound(char[][] board, int row, int column, String word, Stack<List<Integer>> visitedLoc, char letter) {
        if (word.isEmpty()) {
            return true;
        } else if (IndexIsVisited(visitedLoc, row, column) || !isValidPos(board, row, column)) {
            return false;
        } else if (board[row][column] != letter) {
            return false;
        }

        word = word.substring(0, word.length() - 2);
            // 0 -> row, 1 -> column
        List<Integer> visitedIndex = new ArrayList<>();
        visitedIndex.add(row);
        visitedIndex.add(column);
        visitedLoc.push(visitedIndex);
        letter = word.isEmpty() ? Character.MIN_VALUE : word.charAt(word.length() - 1);


        if(     // up
                wordFound(board, row - 1, column, word, visitedLoc, letter)
                // down
                || wordFound(board, row + 1, column, word, visitedLoc, letter)
                // left
                || wordFound(board, row, column - 1, word, visitedLoc, letter)
                // right
                || wordFound(board, row, column + 1, word, visitedLoc, letter)
        ) {
            return true;
        } else {
            visitedLoc.pop();
        }
        return false;
    }

    private boolean IndexIsVisited(List<List<Integer>> visitedLoc, int row, int column) {
        List<Integer> visitedIndex = new ArrayList<>();
        visitedIndex.add(row);
        visitedIndex.add(column);

        return visitedLoc.contains(visitedIndex);
    }

    private boolean isValidPos(char[][] board, int row, int column) {
        return (row >=0 && row < board.length)
                && (column >=0 && column < board[0].length);
    }
}
