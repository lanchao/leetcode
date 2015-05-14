package org.supersense.leetcode.problems.p202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<Integer>();
		if (n == 0) {
			return false;
		}
		while (!set.contains(n)) {
			set.add(n);
			int sum = 0;
			while (n != 0) {
				int d = n % 10;
				n /= 10;
				sum += d * d;
			}
			n = sum;
			if(n == 1){
				return true;
			}
			if(set.contains(n)){
				return false;
			}
		}
		return false;
	}
}
