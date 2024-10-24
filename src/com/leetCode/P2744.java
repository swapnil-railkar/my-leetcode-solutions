package com.leetCode;

public class P2744 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] arr = {"aa","ab"};
        int num = maxPairs(arr);
        System.out.println(num);
	}

	private static int maxPairs(String[] arr) {
		// TODO Auto-generated method stub
		int pair = 0;
		char fc,sc;
		for(int i=0; i< arr.length; i++) {
			fc = arr[i].charAt(0);
			sc = arr[i].charAt(1);
			
			for(int j=i+1; j< arr.length; j++) {
				if((i!=j) && (fc == arr[j].charAt(0) || fc == arr[j].charAt(1))) {
					if(fc == arr[j].charAt(0) && sc == arr[j].charAt(1)) {
						pair++;
					}else if(fc == arr[j].charAt(1) && sc == arr[j].charAt(0)) {
						pair++;
					}
				}
			}
		}
		return pair;
	}

}
