package com.leetCode;

public class P831 {
	public String solution(String s) {
        StringBuilder ans = new StringBuilder();
        if(s.indexOf('@') != -1) {
            // email
            String lower = s.toLowerCase();
            char firstChar = lower.charAt(0);
            int index = lower.indexOf('@');
            char lastChar = lower.charAt(index - 1);
            ans.append(firstChar);
            ans.append("*****");
            ans.append(lastChar);
            ans.append(lower.substring(index));
        } else {
            // phone
            StringBuilder sb = new StringBuilder();
            for(char ch : s.toCharArray()) {
                if(Character.isDigit(ch)) {
                    sb.append(ch);
                }
            }
            String nums = sb.toString();
            String localCode = nums.substring(nums.length() - 4);
            if(nums.length() > 10) {
                int countryCode = nums.length() - 10;
                ans.append("+");
                for(int i=0; i< countryCode; i++) {
                    ans.append("*");
                }
                ans.append("-");
            }
            ans.append("***-***-");
            ans.append(localCode);
        }
        return ans.toString();
    }
}
