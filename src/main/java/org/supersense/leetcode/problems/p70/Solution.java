package org.supersense.leetcode.problems.p70;

public class Solution {
	public int climbStairs(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int[] A = new int[n];
		A[0] = 1;
		A[1] = 2;
		for (int i = 2; i < n; i++) {
			A[i] = A[i - 2] + A[i - 1];
		}
		return A[n - 1];
	}
}
