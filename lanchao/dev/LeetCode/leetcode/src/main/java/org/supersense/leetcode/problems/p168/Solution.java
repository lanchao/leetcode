package org.supersense.leetcode.problems.p168;

public class Solution {
    public String convertToTitle(int n) {
    	return n != 0 ? new StringBuffer().append((char) ('A' + (n - 1) % 26)).insert(0,convertToTitle((n - 1) / 26)).toString():"";
    }
}
