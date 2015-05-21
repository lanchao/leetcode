package org.supersense.leetcode.problems.p97;

public class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length() < s1.length() || s3.length() < s2.length()){
			return false;
		}
		return dp(s1.toCharArray(), s2.toCharArray(), s3.toCharArray());
		// return rece(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0,
		// 0, 0);
	}

	private boolean dp(char[] s1, char[] s2, char[] s3) {
		boolean[][][] dp = new boolean[s1.length + 1][s2.length + 1][s3.length + 1];
		dp[0][0][0] = true;
		for (int i = 0; i < s1.length; i++) {
				dp[i + 1][0][i + 1] = (s1[i] == s3[i]) && dp[i][0][i];
		}
		for (int j = 0; j < s2.length; j++) {
				dp[0][j + 1][j + 1] = (s2[j] == s3[j]) && dp[0][j][j];
		}
		for (int k = 0; k < s3.length; k++) {
			for (int i = 0; i < s1.length; i++) {
				for (int j = 0; j < s2.length; j++) {
					dp[i + 1][j + 1][k + 1] = (s1[i] == s3[k] && dp[i][j + 1][k])
							|| (s2[j] == s3[k] && dp[i + 1][j][k]);
				}
			}
		}
		return dp[s1.length][s2.length][s3.length];
	}

	private boolean rece(char[] s1, char[] s2, char[] s3, int idx1, int idx2,
			int idx3) {
		if (idx1 == s1.length && idx2 == s2.length && idx3 == s3.length) {
			return true;
		}
		if (idx1 == s1.length && idx2 == s2.length || idx3 == s3.length) {
			return false;
		}
		return (idx3 < s3.length && idx1 < s1.length && s1[idx1] == s3[idx3] && rece(
				s1, s2, s3, idx1 + 1, idx2, idx3 + 1))
				|| (idx3 < s3.length && idx2 < s2.length
						&& s2[idx2] == s3[idx3] && rece(s1, s2, s3, idx1,
							idx2 + 1, idx3 + 1));
	}
}
