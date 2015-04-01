package org.supersense.leetcode.problems.p49;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public List<String> anagrams(String[] strs) {
        Map<String, String> map = new HashMap<String, String>();
    	List<String> ret = new LinkedList<String>();
    	Set<String> aset = new HashSet<String>();
    	for(String s: strs){
    		char[] cs = s.toCharArray();
    		Arrays.sort(cs);
    		String ns = String.valueOf(cs);
    		if(map.containsKey(ns)){
    			ret.add(s);
    			aset.add(ns);
    		}else{
    			map.put(ns, s);
    		}
    	}
    	for(String s : aset){
    		ret.add(map.get(s));
    	}
    	return ret;
    }
    
    private List<String> idxmethod(String[] strs){
    	List<String> ret = new LinkedList<String>();
        List<char[]> idxs = new LinkedList<char[]>();
        for(String s : strs){
        	char[] cs = s.toCharArray();
        	char[] nidx = new char[256];
        	boolean found = false;
        	for(char c: cs){
        		nidx[c]++;
        	}
        	for(char[] idx : idxs){
        		if(nidx.length == idx.length){
        			int i = 0;
        			for(i = 0; i < nidx.length; i++){
        				if(nidx[i] != idx[i]){
        					break;
        				}
        			}
        			if(i == nidx.length){
        				ret.add(s);
        				found = true;
        				break;
        			}
        		}
        	}
        	if(!found){
        		idxs.add(nidx);
        	}
        }
        return ret;
    }
}
