package com.leetCode;

public class P8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str = "-13+8"; //Expected : -13
        int num = myAtoI(str);
        System.out.println(num);
	}

	private static int myAtoI(String str) {
		// TODO Auto-generated method stub
		String num = "" ; 
        boolean isNeg = false;
        int index = getIndex(str);
        
        if(str.length() == 1 && !isNum(str.charAt(0))) {
        	return 0;
        }
        
        while(index < str.length() && str.charAt(index) != ' ') {
        	if(!isNum(str.charAt(index)) && !isSign(str.charAt(index))) {
        		if(num.isBlank()) {
            		return 0;
        		}else {
        			break;
        		}
        	}else if(isSign(str.charAt(index))) {
        		if((index+1) < str.length()&&!isNum(str.charAt(index+1))) {
        			return 0;
        		}else if((index - 1 ) >= 0 && isNum(str.charAt(index-1))) {
        			//equation check.
        			if((index+1) < str.length() && isNum(str.charAt(index+1))){
        				return getNum(num, isNeg);
        			}else {
        				index++;
        				continue;
        			}
        			
        		}else {
        			if(num.isBlank() && str.charAt(index) == '-') {
        				isNeg = true;
        			}
        			if(num.isBlank()) {
        				num+=str.charAt(index);
        			}else {
        				return 0;
        			}
            		
        		}
        		
        	}else {
        		if(num.isEmpty() && str.charAt(index) == '0') {
        			index++;
        			continue;
        		}else {
        			num+=str.charAt(index);	
        		}
        		
        	}
        	index++;
        }
        
        
		return getNum(num, isNeg);
		
		
	}
	
	private static int getNum(String num, boolean isNeg) {
		try {
			if(num.isEmpty()) {
				return 0;
			}else {
				return Integer.valueOf(num);
			}
		}catch(Exception e) {
			if(isNeg) {
				return -2147483648;
			}
			return Integer.MAX_VALUE;
		}
	}
	
	private static int getIndex(String str) {
		for(int i=0; i< str.length();i++) {
			if(str.charAt(i) != ' ') {
				return i;
			}
		}
		return 0;
	}
	
	private static boolean isSign(char chr) {
		if(chr == '-' || chr == '+') {
			return true;
		}
		return false;
	}

	private static boolean isNum(char chr) {
		switch(chr) {
		case '1':return true;
		case '2':return true;
		case '3':return true;
		case '4':return true;
		case '5':return true;
		case '6':return true;
		case '7':return true;
		case '8':return true;
		case '9':return true;
		case '0':return true;
		}
		return false;
	}
}
