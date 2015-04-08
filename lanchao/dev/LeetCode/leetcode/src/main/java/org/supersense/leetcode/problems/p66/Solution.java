package org.supersense.leetcode.problems.p66;

public class Solution {
	public int[] plusOne(int[] digits) {
		int dig = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + dig;
			dig = sum / 10;
			sum %= 10;
			digits[i] = sum;
			if(dig == 0){
				break;
			}
		}
		if(dig != 0){
			int[] ret = new int[digits.length+1];
			ret[0] = dig;
			System.arraycopy(digits, 0, ret, 1, digits.length);
			return ret;
		}else{
			return digits;
		}
	}
}
