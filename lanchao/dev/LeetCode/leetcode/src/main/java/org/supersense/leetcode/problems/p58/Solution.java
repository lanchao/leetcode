package org.supersense.leetcode.problems.p58;

public class Solution {
    public int lengthOfLastWord(String s) {
        char[] cs = s.toCharArray();
        int i = cs.length - 1;
        while(i >= 0 && cs[i] == ' '){
        	i--;
        }
        int count = 0;
        while(i >= 0 && cs[i] != ' '){
        	i--;
        	count++;
        }
        return count;
    }
}
