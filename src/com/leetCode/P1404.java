package com.leetCode;

public class P1404 {
	public int solution(String s) {
        StringBuilder bin = new StringBuilder(s);
        int steps = 0;
        while(!isOne(bin)) {
            trim(bin);
            int length = bin.length();
            if(bin.charAt(length - 1) == '0') {
                // divide by 2.
                bin.deleteCharAt(length - 1);
            } else {
                // add 1.
                addOne(bin);
            }
            steps++;
        }
        return steps;
    }

    private void addOne(StringBuilder bin) {
       bin.setCharAt(bin.length() - 1, '0');
        int carry = 1;
        
        for(int i = bin.length() - 2; i>=0; i--) {
            if(carry == 0) {
                break;
            } else {
                if(bin.charAt(i) == '0') {
                    bin.setCharAt(i, '1');
                    carry = 0;
                } else {
                    bin.setCharAt(i, '0');
                }
            }
        }
        if(carry == 1) {
            bin.insert(0, '1');
        }
        trim(bin);
    }

    private boolean isOne(StringBuilder bin) {
        return bin.length() == 1 && bin.charAt(0) == '1';
    }

    private void trim(StringBuilder bin) {
        while(bin.length() > 1 && bin.charAt(0) == '0') {
            bin.deleteCharAt(0);
        }
    }
}
