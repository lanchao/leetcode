package org.supersense.leetcode.problems.p132;

public class Solution {
	public int minCut(String s) {
		int n = s.length();
		boolean[][] isPalindr = new boolean[n + 1][n + 1]; // isPalindr[i][j] =
															// true means s[i:j)
															// is a valid
															// palindrome
		int[] dp = new int[n + 1]; // dp[i] means the minCut for s[0:i) to be
									// partitioned

		for (int i = 0; i <= n; i++)
			dp[i] = i - 1;// initialize the value for each dp state.

		for (int i = 2; i <= n; i++) {
			for (int j = i - 1; j >= 0; j--) {
				// if(isPalindr[j][i]){
				if (s.charAt(i - 1) == s.charAt(j)
						&& (i - 1 - j < 2 || isPalindr[j + 1][i - 1])) {
					isPalindr[j][i] = true;
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[n];
	}
}
