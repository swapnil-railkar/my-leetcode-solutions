package com.leetCode;
public class P13 {
//https://leetcode.com/problems/roman-to-integer/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "MMMDCCXXIV";
        int num = convertRomanToInt(s);
        System.out.println(num);
	}
	
	static int convertRomanToInt(String s)   
	  {  
	    int total = 0;    
	    for (int i=0; i<s.length(); i++)   
	    {   
	      int s1 = value(s.charAt(i)); 
	      if (i+1 <s.length())   
	      {   
	        int s2 = value(s.charAt(i+1)); 
	        if (s1 >= s2)   
	        {   
	//if the value of current character is greater or equal to the next symbol  
	          total = total + s1;   
	        }   
	        else  
	        {   
	//if the value of the current character is less than the next symbol  
	          total = total - s1;   
	        }   
	      }   
	      else  
	      {   
	        total = total + s1;   
	      }   
	    }   
	//returns corresponding integer value  
	    return total;   
	  }   
	
	
	 static int value(char r)   
	  {   
	    if (r == 'I')   
	      return 1;   
	    if (r == 'V')   
	      return 5;   
	    if (r == 'X')   
	      return 10;   
	    if (r == 'L')   
	      return 50;   
	    if (r == 'C')   
	      return 100;   
	    if (r == 'D')   
	      return 500;   
	    if (r == 'M')   
	      return 1000;   
	    return -1;   
	  }   

}
