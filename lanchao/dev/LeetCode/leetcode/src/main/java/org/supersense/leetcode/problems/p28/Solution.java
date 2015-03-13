package org.supersense.leetcode.problems.p28;

public class Solution {
    public int strStr(String haystack, String needle) {
    	if(needle == null || haystack == null){
    		return -1;
    	}
    	if(needle.length() == 0 && haystack.length() == 0){
    		return 0;
    	}
    	if(needle.length() > haystack.length()){
    		return -1;
    	}
        char[] ss = haystack.toCharArray();
        char[] s = needle.toCharArray();
        int idx = 0;
        while(idx <= ss.length - s.length){
        	int i = 0;
        	for(i = 0; i < s.length; i++){
        		if(ss[i+idx] != s[i]){
        			break;
        		}
        	}
        	if(i == s.length){
        		return idx;
        	}else{
        		idx += 1;
        	}
        }
        return -1;
    }
}
