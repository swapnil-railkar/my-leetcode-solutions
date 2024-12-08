package com.leetCode;

public class P65 {
	
	public boolean solution(final String number) {
		try {
            boolean decimalPointEnc = false;
            boolean hasNum = false;
            for (int i = 0; i < number.length(); i++) {
                char currChar = number.charAt(i);
                if (isNum(currChar)) {
                    hasNum = true;
                    continue;
                } else if (currChar == 'e' || currChar == 'E') {
                    if (i == 0 || i == number.length() - 1 || !hasNum) {
                        return false;
                    }
                    return isValidNumber(number, i + 1, number.length());
                } else if (currChar == '-' || currChar == '+') {
                    // TODO validate signs
                    if (i != 0) {
                        return false;
                    }
                } else if (currChar == '.') {
                    if (decimalPointEnc) {
                        return false;
                    }
                    decimalPointEnc = true;
                    // TODO validate decimal point
                    if (i < number.length() - 1 && isNum(number.charAt(i + 1))) {
                        continue;
                    }
                    if (i == 0) {
                        return false;
                    } else if (number.charAt(i - 1) != '-' && number.charAt(i - 1) != '+'
                            && !isNum(number.charAt(i - 1))) {
                        return false;
                    }
                } else {
                    // currChar is alphabet
                    return false;
                }

            }

            return hasNum;
        } catch (Exception e) {
            return false;
        }
	}
	
	private boolean isValidNumber(final String number, final int start, final int end) {
        // only valid characters are numbers and sign if it is first
        try {
            for (int i = start; i < end; i++) {
                if (number.charAt(i) == '-' || number.charAt(i) == '+') {
                    if (i != start || !isNum(number.charAt(i+1))) {
                        return false;
                    }
                } else if (!isNum(number.charAt(i))) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isNum(final char num) {
        return Character.isDigit(num);
    }

}
