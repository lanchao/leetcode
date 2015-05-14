package org.supersense.leetcode.problems.p201;

public class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		int mask = 0x80000000;
		int ret = 0;
		boolean begin = true;
		for (int i = 0; i < 32; i++) {
			if ((m & mask) == 0 && (n & mask) == 0) {
				if(begin){
					
				}else{
					ret <<= 1;
				}
			} else if ((m & mask) == mask && (n & mask) == mask) {
				begin = false;
				ret <<= 1;
				ret += 1;
			}else{
				if(begin){
					return 0;
				}else{
					ret <<= (32 - i);
					return ret;
				}
			}
			m = m << 1;
			n = n << 1;
		}
		return ret;
	}
}
