package org.supersense.leetcode.problems.p72;

public class Solution {
	public int minDistance(String word1, String word2) {
		char[] ws1 = word1.toCharArray();
		char[] ws2 = word2.toCharArray();
		int[][] dp = new int[ws1.length+1][ws2.length+1];
		for (int i = 0; i <= ws1.length; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= ws2.length; j++) {
			dp[0][j] = j;
		}
		for (int i = 1; i <= ws1.length; i++) {
			for (int j = 1; j <= ws2.length; j++) {
				int tmin = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
				int diff = (ws1[i-1] == ws2[j-1]) ? 0 : 1;
				dp[i][j] = Math.min(tmin, dp[i - 1][j - 1] + diff);
			}
		}
		return dp[ws1.length][ws2.length];
	}
}
