package org.supersense.leetcode.problems.p165;

public class Solution {

	public int compareVersion(String version1, String version2) {
		String input1 = version1;
		String input2 = version2;
		if(!version1.contains(".")){
			input1 = version1 + ".0";
		}
		
		if(!version2.contains(".")){
			input2 = version2 + ".0";
		}
		
		String[] v1 = input1.split("\\.");
		String[] v2 = input2.split("\\.");
		int i = 0;
		for(i = 0; i < v2.length && i < v1.length; i++){
			String s = v1[i];
			String t = v2[i];
			if (comp(s, t) != 0) {
				return comp(s, t);
			}
		}
		if(v1.length == v2.length){
			return 0;
		}else if(v1.length > v2.length){
			for(int j = i; j < v1.length; j++){
				if(!trimZeros(v1[j]).equals("")){
					return 1;
				}
			}
			return 0;
		}else{
			for(int j = i; j < v2.length; j++){
				if(!trimZeros(v2[j]).equals("")){
					return -1;
				}
			}
			return 0;
		}
	}

	public int comp(String s1, String s2) {
		String ss1 = s1, ss2 = s2;
		if (s1.startsWith("0")) {
			ss1 = trimZeros(s1);
		}
		if (s2.startsWith("0")) {
			ss2 = trimZeros(s2);
		}

		if (ss1.length() > ss2.length()) {
			return 1;
		} else if (ss1.length() < ss2.length()) {
			return -1;
		} else {

			int comp = ss1.compareTo(ss2);

			if (comp > 0) {
				return 1;
			} else if (comp < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}

	public String trimZeros(String s) {
		int i = 0;
		for (i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '0') {
				break;
			}
		}
		return s.substring(i);
	}
}
