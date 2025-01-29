package com.leetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class P36 {

    public boolean validSudoku(char[][] sudoku) {
        if (!validBoard(sudoku)) {
            return false;
        }
        boolean allColumnsValid = false;
        // 9 + 9
        for (char[] row : sudoku) {
            for (int i=0; i< row.length; i++) {
                if (!validRow(row)) {
                    return false;
                }
                if (!allColumnsValid) {
                    if (!validColumn(sudoku, i)) {
                        return false;
                    }
                }
            }
            allColumnsValid = true;
        }
        // All rows and columns are validated, validate boxes.
        // box 1
        return validBox(sudoku, 0, 0)
                && validBox(sudoku, 0, 3)
                && validBox(sudoku, 0, 6)
                && validBox(sudoku, 3, 0)
                && validBox(sudoku, 3, 3)
                && validBox(sudoku, 3, 6)
                && validBox(sudoku, 6, 0)
                && validBox(sudoku, 6, 3)
                && validBox(sudoku, 6, 6);
    }

    private boolean validBoard(char[][] board) {
        return (board.length == 9) && (board[0].length == 9);
    }
    private boolean validRow(char[] row) {
        List<Character> elements = new ArrayList<>();

        for (char c : row) {
            if (isNum(c)) {
                if (!elements.isEmpty() && elements.contains(c)) {
                    return false;
                } else {
                    elements.add(c);
                }
            }
        }
        return true;
    }

    private boolean validColumn(char[][] arr, int column) {
        List<Character> elements = new ArrayList<>();
        for (char[] chars : arr) {
            char val = chars[column];
            if (isNum(val)) {
                if (!elements.isEmpty() && elements.contains(val)) {
                    return false;
                } else {
                    elements.add(val);
                }
            }
        }
        return true;
    }

    private boolean validBox(char[][] box, int startRow, int startColumn) {
        List<Character> elements = new ArrayList<>();
        int endRow = startRow + 3;
        int endColumn = startColumn + 3;
        for (int i = startRow; i< endRow; i++) {
            for (int j = startColumn; j< endColumn; j++) {
                char entry = box[i][j];
                if (isNum(entry)) {
                    if (!elements.isEmpty() && elements.contains(entry)) {
                        return false;
                    } else {
                        elements.add(entry);
                    }
                }
            }
        }
        return true;
    }

    private boolean isNum(char num) {
        return Character.isDigit(num);
    }
}
