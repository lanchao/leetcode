package org.supersense.leetcode.problems.p44;
/**
 * KMP Algorithm
 * @author lanchao
 *
 */
public class Solution {
	public boolean isMatch(String s, String p) {
	    if (p.replace("*", "").length() > s.length())
	        return false;
		char[] cs = s.toCharArray();
		char[] ps = p.toCharArray();
		boolean[] dp = new boolean[cs.length + 1];
		dp[0] = true;
		for(int i = 0; i < ps.length; i++){
			if(ps[i] == '*'){
				for(int j = 0; j < cs.length; j++){
					dp[j + 1] = dp[j] || dp[j + 1];
				}
			}else{
				for(int j = cs.length - 1; j >=0; j--){
					dp[j + 1] = (ps[i] == '?' || ps[i] == cs[j]) && dp[j];
				}
				dp[0] = false;
			}
		}
		return dp[cs.length];
	}
	
	private int kmp(String s, String p){
		int i = 0, j = 0;
		char[] cs = s.toCharArray();
		char[] cp = p.toCharArray();
		int[] next = getNext(cp);
		while(i < cs.length && j < cp.length){
			if(j == -1 || cs[i] == cp[j]){
				i++;
				j++;
			}else{
				j = next[j];
			}
		}
		if(j == cp.length){
			return i - j;
		}else{
			return -1;
		}
	}
	
	private int[] getNext(char[] p) {
		int[] next = new int[p.length];
		next[0] = -1;
		int pos = 0, cnd = -1;
		while(pos < p.length){
			if(cnd == -1 || p[pos] == p[cnd]){
				cnd++;
				pos++;
				next[pos] = cnd;
			}else{
				cnd = next[cnd];
			}
		}
		return next;
	}

}
