package org.supersense.leetcode.problems.p187;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    	List<String> ret = new LinkedList<String>();
        if(s == null || s.length() <= 10){
        	return ret;
        }
        Set<Integer> set = new HashSet<Integer>();
        Set<String> reset = new HashSet<String>();
        for(int i = 0; i <= s.length() - 10; i++){
        	String p = s.substring(i, i+10);
        	int pi = strToInt(p);
        	if(set.contains(pi)){
        		reset.add(p);
        	}else{
        		set.add(pi);
        	}
        }
        ret.addAll(reset);
        return ret;
    }
    
    private int strToInt(String s){
    	int ret = 0;
    	char[] cs = s.toCharArray();
    	for(int i = 0; i<cs.length; i++){
    		switch(cs[i]){
    		case 'A':
    			ret = ret << 2;
    			break;
    		case 'C':
    			ret = ret << 2;
    			ret += 1;
    			break;
    		case 'G':
    			ret = ret << 2;
    			ret += 2;
    			break;
    		case 'T':
    			ret = ret << 2;
    			ret += 3;
    			break;
    		}
    	}
    	return ret;
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
		while(pos < p.length -1){
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
