package org.supersense.leetcode.problems.p7;

public class Solution {
	public int reverse(int x) {
		int num = x > 0 ? x : -x;
		int ret = 0;
		while (num > 0) {
			if(ret > Integer.MAX_VALUE / 10){
				return 0;
			}
			ret *= 10;
			ret += num % 10;
			num /= 10;
		}
		return x > 0 ? ret : -ret;
	}
}
