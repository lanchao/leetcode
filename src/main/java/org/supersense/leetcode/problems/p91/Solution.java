package org.supersense.leetcode.problems.p91;

public class Solution {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.equals("0")) {
			return 0;
		}
		if (s.length() == 1) {
			return 1;
		}
		char[] cs = s.toCharArray();
		int[] dp = new int[cs.length + 1];
		dp[cs.length] = 1;
		dp[cs.length - 1] = (cs[cs.length - 1])== '0' ? 0 : 1;
		for(int i = cs.length - 2; i >=0; i--){
			if(cs[i] != '0'){
				dp[i] += dp[i+1];
				if((cs[i] - '0')*10 + (cs[i+1] - '0') <= 26){
					dp[i]+=dp[i+2];
				}
			}
		}
		return dp[0];
	}
}
