package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P51 {
	public List<List<String>> solution(int n) {
        List<List<String>> answers = new ArrayList<>();
        Position[] position = new Position[n];
        solve(0, position, n, answers);
        return answers;
    }

    private void solve(int row, Position[] position, int n, List<List<String>> answers) {
        if(row == n) {
            StringBuilder sb = null;
            List<String> answer = new ArrayList<>();
            for(Position p : position) {
                sb = new StringBuilder();
                for(int column = 0; column < n; column++) {
                    if(column == p.column) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                answer.add(sb.toString());
            }
            answers.add(answer);
            return;
        }
        for(int column = 0; column < n; column++) {
            boolean found = true;
            for(int queen = 0; queen < row; queen++) {
                if(position[queen].column == column || position[queen].column - position[queen].row == column - row 
                    || position[queen].column + position[queen].row == column + row) {
                    found = false;
                    break;
                }
            } 
            if(found) {
                position[row] = new Position(row, column);
                solve(row + 1, position, n, answers);
            }
        }
    }

    private static class Position {
        int column;
        int row;
        Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
