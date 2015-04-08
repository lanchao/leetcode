package org.supersense.leetcode.problems.p71;

public class Solution {
	public String simplifyPath(String path) {
		char[] cs = path.toCharArray();
		char[] s = new char[cs.length];
		int top = -1;
		int i = 0;
		while (i < cs.length) {
			char c = cs[i];
			if (top == -1) {
				s[++top] = c;
			} else {
				if (c == '/') {
					if (s[top] != '/') {
						if (s[top] == '.') {
							if (s[top - 1] == '.') {
								if(s[top-2] != '.'){
								while (s[top] != '/')
									top--;
								if (top != 0) {
									top--;
									while (s[top] != '/')
										top--;
								}
								}
							} else {
								while (s[top] != '/')
									top--;
							}
						}else{
							s[++top] = c;
						}
					}
				} else {
					s[++top] = c;
				}
			}
			i++;
		}
		
		if (s[top] == '.') {
			if (s[top - 1] == '.') {
				if (s[top - 2] != '.') {
					while (s[top] != '/')
						top--;
					if (top != 0) {
						top--;
						while (s[top] != '/')
							top--;
					}
				}
			} else {
				while (s[top] != '/')
					top--;
			}
		}
		
		if (top != 0 && s[top] == '/')
			top--;
		return String.copyValueOf(s, 0, top + 1);
	}
}
