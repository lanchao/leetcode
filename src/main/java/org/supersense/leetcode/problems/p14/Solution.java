package org.supersense.leetcode.problems.p14;

public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		char[] cc1 = strs[0].toCharArray();
		int end = cc1.length;
		for(int i = 1; i < strs.length ;i++){
			String curr = strs[i];
			char[] cc2 = curr.toCharArray();
			int len = Math.min(end,  cc2.length);
			int j = 0;
			for(j = 0; j < len; j++){
				if(cc1[j]!= cc2[j]){
					break;
				}
			}
			end = j;
		}
		return strs[0].substring(0, end);
	}
}
