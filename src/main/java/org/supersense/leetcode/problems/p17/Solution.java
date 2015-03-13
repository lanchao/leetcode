package org.supersense.leetcode.problems.p17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
	private Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
    public List<String> letterCombinations(String digits) {
    	List<String> ret = new LinkedList<String>();
        map.put(2, Arrays.asList("a","b","c"));
        map.put(3, Arrays.asList("d","e","f"));
        map.put(4, Arrays.asList("g","h","i"));
        map.put(5, Arrays.asList("j","k","l"));
        map.put(6, Arrays.asList("m","n","o"));
        map.put(7, Arrays.asList("p","q","r","s"));
        map.put(8, Arrays.asList("t","u","v"));
        map.put(9, Arrays.asList("w","x","y","z"));
        
    	dfs(map, ret, "", digits);
    	
    	return ret;
    }
    
    private void dfs(Map<Integer, List<String>> map, List<String> ret, String par, String digits){
    	if(digits == null || digits.length() == 0){
    		return;
    	}
    	int num = digits.charAt(0) - '0';
    	if(map.containsKey(num)){
    		List<String> ls = map.get(num);
  			if(digits.length() == 1){
  				for(String s : ls){
  	    			String news = par+s;
  	    			ret.add(news);
  	    		}
			}else{
				String newdigits = digits.substring(1);
				for(String s :ls){
					String news = par+s;
					dfs(map,ret,news,newdigits);
				}
			}
    	}else{
    		dfs(map,ret,par,digits.substring(1));
    	}
    }
}
