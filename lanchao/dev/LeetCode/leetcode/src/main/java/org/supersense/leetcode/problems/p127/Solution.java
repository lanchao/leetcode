package problems.p127;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.List;

public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(start, 1));
        dict.remove(start);
        while(!queue.isEmpty()){
        	Pair p = queue.poll();
        	if(p.word.equals(end)){
        		return p.count;
        	}
        	char[] cc = p.word.toCharArray();
        	for(int i = 0; i < cc.length ; i++){
        		char t = cc[i];
        		for(cc[i] = 'a'; cc[i] <= 'z'; cc[i]++){
        			String rep = String.valueOf(cc);
        			if(dict.contains(rep)){
        				queue.add(new Pair(rep, p.count + 1));
        				dict.remove(rep);
        			}
        		}
        		cc[i] = t;
        	}
        	
        }
        return 0;
    }
    
    public boolean editDistanceOne(String s1, String s2){
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
}

class Pair {

	public String word;
	public int count;
	public Pair(String word, int count){
		this.word = word;
		this.count = count;
	}
}
