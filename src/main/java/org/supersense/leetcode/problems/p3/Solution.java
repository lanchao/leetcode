package org.supersense.leetcode.problems.p3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	public int lengthOfLongestSubstring1(String s) {
		int max = 0;
		int prev = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] cc = s.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			if (map.containsKey(cc[i])) {
				prev = Math.max(prev, map.get(cc[i]) + 1);
			}
			max = Math.max(max, i - prev + 1);
			map.put(cc[i], i);
		}
		return max;
	}
	
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int left = 0, right = 0;
		Set<Character> set = new HashSet<Character>();
		while(right < s.length()){
			if(set.contains(s.charAt(right))){
				if(max < right - left){
					max = right - left;
				}
				while(s.charAt(left)!=s.charAt(right)){
					set.remove(s.charAt(left));
					left++;
				}
				left++;
			}else{
				set.add(s.charAt(right));
			}
			right++;
		}
		max = Math.max(max, right - left);
		return max;
	}
	
}
