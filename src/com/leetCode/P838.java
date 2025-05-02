package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class P838 {

	public String solution(String dominoes) {
        int[] values = new int[dominoes.length()];
        Map<Character, Integer> charValueMap = new HashMap<>();
        charValueMap.put('.', 0);
        charValueMap.put('R', -1);
        charValueMap.put('L', 1);
        int lastRIndex = -1;
        int lastLIndex = -1;
        for (int i = 0; i < dominoes.length(); i++) {
            char currChar = dominoes.charAt(i);
            if (currChar == 'R') {
                if (lastRIndex > lastLIndex) {
                    setValues(lastRIndex, i, values, charValueMap.get(currChar));
                }
                lastRIndex = i;
            }
            if (currChar == 'L') {
                if (lastRIndex == -1) {
                    setValues(0, i, values, charValueMap.get(currChar));
                } else if(lastLIndex > lastRIndex) {
                	setValues(lastLIndex, i, values, charValueMap.get(currChar));
                } else if ((i + lastRIndex) % 2 == 0) {
                    int mid = (i + lastRIndex) / 2;
                    values[mid] = 0;
                    setValues(lastRIndex, mid - 1, values, charValueMap.get('R'));
                    setValues(mid + 1, i, values, charValueMap.get(currChar));
                } else if ((i + lastRIndex) % 2 != 0) {
                    int mid = (i + lastRIndex) / 2;
                    setValues(lastRIndex, mid, values, charValueMap.get('R'));
                    setValues(mid + 1, i, values, charValueMap.get(currChar));
                }
                lastLIndex = i;
            }
        }

        if (lastRIndex > lastLIndex) {
            setValues(lastRIndex, values.length - 1, values, charValueMap.get('R'));
        }

        return convertValuesToString(values);
    }

    private String convertValuesToString(int[] values) {
        Map<Integer, Character> valueCharacterMap = new HashMap<>();
        valueCharacterMap.put(0, '.');
        valueCharacterMap.put(-1, 'R');
        valueCharacterMap.put(1, 'L');
        StringBuilder state = new StringBuilder();
        for (int value : values) {
            state.append(valueCharacterMap.get(value));
        }
        return state.toString();
    }

    private void setValues(int start, int end, int[] values, int value) {
        for (int i = start; i <= end; i++) {
            values[i] = value;
        }
    }
}
