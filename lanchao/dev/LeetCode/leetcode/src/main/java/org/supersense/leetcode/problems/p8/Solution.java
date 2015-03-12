package org.supersense.leetcode.problems.p8;

public class Solution {
	public int atoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		String ts = str.trim();
		Boolean positive = true;
		int start = 0;
		if (ts.startsWith("+") || ts.startsWith("-")) {
			if (ts.startsWith("-")) {
				positive = false;
			}
			start = 1;
		}
		char[] cc = ts.toCharArray();
		long ret = 0;
		for (int i = start; i < cc.length; i++) {
			if (Character.isDigit(cc[i])) {
				if (positive) {
					ret *= 10;
					ret += (cc[i] - '0');
					if (ret > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				} else {
					ret *= 10;
					ret -= (cc[i] - '0');
					if (ret < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				}
			}else {
				break;
			}
		}
		return (int) ret;
	}
}
