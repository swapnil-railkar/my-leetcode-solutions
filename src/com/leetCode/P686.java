package com.leetCode;

public class P686 {
	public int solution(String a, String b) {
		if(b.length() == 0) {
            return 0;
        }
        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        while(sb.length() < b.length()) {
            sb.append(a);
            count++; 
        }

        if(sb.indexOf(b) != -1) {
            return count;
        }

        sb.append(a);

        return sb.indexOf(b) != -1 ? count + 1: - 1;
    }
}
