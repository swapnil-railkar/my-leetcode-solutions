package com.leetCode;

public class P3484 {
	private int[][] sheet = null;
    public P3484(int rows) {
        sheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int[] dest = getCell(cell);
        sheet[dest[0]][dest[1]] = value;
    }
    
    public void resetCell(String cell) {
        setCell(cell, 0);
    }
    
    public int getValue(String formula) {
        StringBuilder sb = new StringBuilder(formula);
        sb.deleteCharAt(0);
        String[] cells = sb.toString().split("\\+");
        return toValue(cells[0]) + toValue(cells[0]);
    }

    private int toValue(String formula) {
        if(Character.isDigit(formula.charAt(0))) {
            return Integer.valueOf(formula);
        }
        int[] dest = getCell(formula);
        return sheet[dest[0]][dest[1]];
    }

    private int[] getCell(String cell) {
        int col = cell.charAt(0) - 'A';
        StringBuilder sb = new StringBuilder(cell);
        sb.deleteCharAt(0);
        int row = Integer.valueOf(sb.toString()) - 1;
        return new int[] {row, col};
    }
}
