package org.supersense.leetcode.problems.p205;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s == null || s.isEmpty()){
        	return true;
        }
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Map<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i < cs.length; i++){
        	if(map.containsKey(cs[i])){
        		if(ct[i] != map.get(cs[i])){
        			return false;
        		}
        	}else{
        		if(map.containsValue(ct[i])){
        			return false;
        		}
        		map.put(cs[i],ct[i]);
        	}
        }
        return true;
    }
}
