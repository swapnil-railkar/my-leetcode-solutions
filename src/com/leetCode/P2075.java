package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class P2075 {
	public String solution(String encodedText, int rows) {
        int columns = encodedText.length() / rows;
        List<String> rowList = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0;i < encodedText.length(); i++) {
            char curr = encodedText.charAt(i);
            if(str.length() == columns) {
                rowList.add(str.toString());
                str = new StringBuilder();
            }
            str.append(curr);
        }
        rowList.add(str.toString());
        str = new StringBuilder();
        for(int col = 0; col < columns; col++) {
            int curr = col;
            for(String row : rowList) {
                if(row.length() > curr) {
                    str.append(row.charAt(curr));
                }
                curr++;
            }
        }
        return str.toString().stripTrailing();
    }
}
