package org.supersense.leetcode.problems.p115;

import java.util.Arrays;

public class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length()+1][s.length()+1];
        Arrays.fill(dp[0], 1);
        for(int i = 1; i <= t.length();i++){
        	dp[i][0] = 0;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        for(int i = 0; i < t.length();i++){
        	for(int j = 0; j < s.length(); j++){
        		if(ct[i] == cs[j]){
        			dp[i+1][j+1] = dp[i+1][j] + dp[i][j];
        		}else{
        			dp[i+1][j+1] = dp[i+1][j];
        		}
        	}
        }
        return dp[t.length()][s.length()];
    }
}
