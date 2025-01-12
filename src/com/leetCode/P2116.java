package com.leetCode;


public class P2116 {

	public boolean solution(String brackets, String locked) {
		if(brackets.length() % 2 == 1) {
			return false;
		}
		
		for(int i=0 ; i< brackets.length(); i++) {
			if(locked.charAt(i) == '1') {
				if(brackets.charAt(i) == ')') {
					int requiredEditables = 1;
					int j = i - 1;
					try {
						while(requiredEditables > 0) {
							if(locked.charAt(j) == '0') {
								requiredEditables--;
							} else {
								// locked.charAt(j) == '1'
								if(brackets.charAt(j) == '(') {
									requiredEditables--;
								} else {
									// locked.charAt(j) == '1' & brackets.charAt(j) == ')'
									requiredEditables++;
								}
							}
							j--;
						}
					} catch (Exception e) {
						return false;
					}
				} else {
					// brackets.charAt(i) == '('
					if(i ==  brackets.length() - 1) {
						return false;
					} else {
						int requiredEditables = 1;
						int j = i + 1;
						try {
							while(requiredEditables > 0) {
								if(locked.charAt(j) == '0') {
									requiredEditables--;
								} else {
									// locked.charAt(j) == '1'
									if(brackets.charAt(j) == ')') {
										requiredEditables--;
									} else {
										// locked.charAt(j) == '1' & brackets.charAt(j) == '('
										requiredEditables++;
									}
								}
								j++;
							}
						} catch (Exception e) {
							return false;
						}
					}
				}
			}
		}
		
		return true;
	}
}
