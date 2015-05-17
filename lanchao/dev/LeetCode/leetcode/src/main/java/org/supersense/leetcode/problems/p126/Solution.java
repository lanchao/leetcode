package org.supersense.leetcode.problems.p126;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	private int shortest = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> ret = new LinkedList<List<String>>();
    	List<String> ll = new LinkedList<String>();
    	//dict.add(end);
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	buildgraph(map, dict, start, end);
    	dfsOnMap(map, start, end, dict, ret, ll, 0);
    	return ret;
    }
    
    private void dfsOnMap(Map<String, List<String>> map, String start, String end, Set<String> dict, List<List<String>> ret, List<String> pl, int depth){
    	List<String> curr = new LinkedList<String>();
    	
    	if(depth > shortest){
    		return;
    	}
    	if(dict.isEmpty()){
    		return;
    	}
    	curr.addAll(pl);
    	curr.add(start);
    	if(start.equals(end)){
    		if(depth <= shortest){
    			shortest = depth;
    			ret.add(curr);
    			return;
    		}
    		return;
    	}
    	List<String> candlist = map.get(start);
    	for(String rep : candlist){
    			if(dict.contains(rep)){
    				dict.remove(rep);
    				dfsOnMap(map, rep, end, dict, ret, curr, depth + 1);
    				dict.add(rep);
    			}
    		}
    }
    
    private void dfs(String start, String end, Set<String> dict, List<List<String>> ret, List<String> pl, int depth){
    	List<String> curr = new LinkedList<String>();
    	
    	if(depth > shortest){
    		return;
    	}
    	if(dict.isEmpty()){
    		return;
    	}
    	curr.addAll(pl);
    	curr.add(start);
    	if(start.equals(end)){
    		if(depth <= shortest){
    			shortest = depth;
    			ret.add(curr);
    			return;
    		}
    		return;
    	}
    	
    	char[] cc = start.toCharArray();
    	for(int i = 0; i < cc.length ; i++){
    		char t = cc[i];
    		for(cc[i] = 'a'; cc[i] <= 'z'; cc[i]++){
    			String rep = String.valueOf(cc);
    			if(dict.contains(rep)){
    				dict.remove(rep);
    				dfs(rep, end, dict, ret, curr, depth + 1);
    				dict.add(rep);
    			}
    		}
    		cc[i] = t;
    	}
    }
    
    private boolean editDistanceOne(String s1, String s2){
    	int count = 0;
    	char[] c1 = s1.toCharArray();
    	char[] c2 = s2.toCharArray();
    	for(int i = 0; i < s1.length(); i++){
    		if(c1[i] != c2[i]){
    			count ++;
    			if(count > 1){
    				return false;
    			}
    		}
    	}
    	if(count == 1){
    		return true;
    	}
    	return false;
    }
    
    private void buildgraph(Map<String, List<String>> map, Set<String> dict, String start, String end){
    	List<String> sl = new LinkedList<String>();
    	Set<String> temp = new HashSet<String>();
    	temp.addAll(dict);
    	temp.add(end);
    	for(String s: temp){
    		if(editDistanceOne(start, s)){
    			sl.add(s);
    		}
    	}
    	map.put(start, sl);
    	
    	for(String s : dict){
    		temp.remove(s);
    		List<String> ll = new LinkedList<String>();
    		for(String t : temp){
    			if(editDistanceOne(s, t)){
    				ll.add(t);
    			}
    		}
    		temp.add(s);
    		map.put(s, ll);
    	}
    }
}
