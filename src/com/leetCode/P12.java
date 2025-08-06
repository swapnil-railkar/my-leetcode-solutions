package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P12 {
	public String solution(int num) {
        Map<Integer, Character> valueSymbolMap = new HashMap<>();
        valueSymbolMap.put(1, 'I');
        valueSymbolMap.put(5, 'V');
        valueSymbolMap.put(10, 'X');
        valueSymbolMap.put(50, 'L');
        valueSymbolMap.put(100, 'C');
        valueSymbolMap.put(500, 'D');
        valueSymbolMap.put(1000, 'M');

        List<Integer> digits = new ArrayList<>();
        String numStr = String.valueOf(num);
        for(int i = 0; i< numStr.length(); i++) {
            digits.add(Character.getNumericValue(numStr.charAt(i)));
        }

        String ans = "";
        for(int i = 0; i< digits.size(); i++) {
            int pow = (int) Math.pow(10, digits.size() - (i + 1));
            int n = digits.get(i) * pow;
            ans += getRomanString(n, pow, valueSymbolMap);
        }
        return ans;
    }

    private String getRomanString(int num, int pow, Map<Integer, Character> valueSymbolMap) {
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            if(valueSymbolMap.containsKey(num + pow)) {
                sb.append(valueSymbolMap.get(pow));
                sb.append(valueSymbolMap.get(num + pow));
                num = 0;
            } else {
                int closest = getClosestMatch(num, valueSymbolMap);
                sb.append(valueSymbolMap.get(closest));
                num -= closest;
            }
        }
        return sb.toString();
    }

    private int getClosestMatch(int num, Map<Integer, Character> valueSymbolMap) {
        if(valueSymbolMap.containsKey(num)) {
            return num;
        }
        int closest = Integer.MIN_VALUE;
        for(int key : valueSymbolMap.keySet()) {
            if(key < num) {
                closest = Math.max(closest, key);
            }
        }
        return closest;
    }
}
