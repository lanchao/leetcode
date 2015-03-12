package org.supersense.leetcode.problems.p13;

public class Solution {
	public int romanToInt(String s) {
		char[] cc = s.toCharArray();
		int i = 0;
		int ret = 0;
		while (i < s.length()) {
			switch (cc[i++]) {
			case 'M':
				ret += 1000;
				break;
			case 'D':
				ret += 500;
				break;
			case 'L':
				ret += 50;
				break;
			case 'V':
				ret += 5;
				break;
			case 'C':
				if ((i< s.length()) && cc[i] == 'M') {
					ret += 900;
					i++;
				} else if ((i< s.length()) && cc[i] == 'D') {
					ret += 400;
					i++;
				} else {
					ret += 100;
				}
				break;
			case 'X':
				if ((i< s.length()) && cc[i] == 'C') {
					ret += 90;
					i++;
				} else if ((i< s.length()) && cc[i] == 'L'){
					ret += 40;
					i++;
				}else{
					ret += 10;
				}
				break;
			case 'I':
				if ((i< s.length()) && cc[i] == 'X') {
					ret += 9;
					i++;
				}else if ((i< s.length()) && cc[i] == 'V'){
					ret += 4;
					i++;
				}else {
					ret += 1;
				}
				break;
			}
		}
		return ret;
	}
}
