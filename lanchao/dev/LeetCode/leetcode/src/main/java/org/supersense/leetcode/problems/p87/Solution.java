package org.supersense.leetcode.problems.p87;

import java.util.Arrays;

public class Solution {
	public boolean isScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		Arrays.sort(cs1);
		Arrays.sort(cs2);
		if(!String.copyValueOf(cs1).equals(String.copyValueOf(cs2)))
			return false;
		if (s1.equals(s2))
			return true;
		for (int i = 1; i < s1.length(); i++) {
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i);
			if (isScramble(s11, s21) && isScramble(s12, s22))
				return true;
			s21 = s2.substring(s2.length() - i);
			s22 = s2.substring(0, s2.length() - i);
			if (isScramble(s11, s21) && isScramble(s12, s22))
				return true;
		}
		return false;
	}
	public boolean isScrambleDP(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		int len = cs1.length;
		boolean[][][] dp = new boolean[len+1][len][len];
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len; j++){
				dp[1][i][j] = cs1[i] == cs2[j];
			}
		}
		
		for(int k = 2; k <= len; k++){
			for(int i = len - k; i >=0; i--){
				for(int j = len - k; j >= 0; j--){
					boolean isScramble = false;
					for(int m = 1; m < k; m++){
						isScramble = dp[m][i][j] && dp[k-m][i+m][j+m] || dp[m][i][j+k-m] && dp[k-m][i+m][j];
						if(isScramble)
							break;
					}
					dp[k][i][j] = isScramble;
				}
			}
		}
		return dp[len][0][0];
	}
}
