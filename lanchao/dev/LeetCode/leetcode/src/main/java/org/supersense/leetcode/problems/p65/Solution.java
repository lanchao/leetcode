package org.supersense.leetcode.problems.p65;

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        char[] cs = s.toCharArray();
        boolean hasNumber = false, hasNumberAfterE = true, hasDot = false, hasE = false;
        
        for(int i = 0; i < cs.length; i++){
        	if(cs[i] >= '0' && cs[i] <= '9'){
        		hasNumber = true;
        		hasNumberAfterE = true;
        	}else if(cs[i] == 'e'){
        		if(hasE || !hasNumber){
        			return false;
        		}
        		hasE = true;
        		hasNumberAfterE = false;
        	}else if(cs[i] == '.'){
        		if(hasDot || hasE){
        			return false;
        		}
        		hasDot = true;
        	}else if(cs[i] == '+' || cs[i] == '-'){
        		if(i != 0 && cs[i-1] != 'e'){
        			return false;
        		}
        	}else{
        		return false;
        	}
        }
        return hasNumber && hasNumberAfterE;
    }
}
