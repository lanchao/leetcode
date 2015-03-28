package org.supersense.leetcode.problems.p38;

public class Solution {
	public String countAndSay(int n){
		String pre = "1";
		if(n == 1){
			return pre;
		}
		for(int i = 2; i <= n; i++){
			StringBuffer sb = new StringBuffer();
			char[] cs = pre.toCharArray();
			char p = cs[0];
			int count = 0;
			for(int j = 0; j < cs.length; j++){
				if(cs[j] != p){
					sb.append(count);
					sb.append(p);
					p = cs[j];
					count = 1;
				}else{
					count++;
				}
			}
			sb.append(count);
			sb.append(p);
			pre = sb.toString();
		}
		return pre;
	}
}
