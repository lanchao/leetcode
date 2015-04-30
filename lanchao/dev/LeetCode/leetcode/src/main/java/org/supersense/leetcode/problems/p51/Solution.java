package org.supersense.leetcode.problems.p51;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String[]> solveNQueens(int n) {
    	List<String[]> ret = new LinkedList<String[]>();
    	if(n <= 0)
    		return ret;
        char[][] queen = new char[n][n];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		queen[i][j] = '.';
        	}
        }
        solve(queen, ret, 0);
        return ret;
    }
    
    private void solve(char[][] queen, List<String[]> ret, int level) {
    	if(level >= queen.length){
			String[] ns = new String[queen.length];
    		for(int i = 0; i < queen.length; i++){
    			ns[i] = String.valueOf(queen[i]);
    		}
			ret.add(ns);
			return;
    	}
    	for(int i = 0; i < queen.length; i++){
    		if(isValid(queen, level, i)){
    			queen[level][i] = 'Q';
    			solve(queen, ret, level + 1);
    			queen[level][i] = '.';
    		}
    	}
    }
    
    private boolean isValid(char[][] queen, int x, int y){
    	for(int i = 0; i < queen.length; i++){
    		if(queen[x][i] == 'Q')
    			return false;
    		if(queen[i][y] == 'Q')
    			return false;
    		if((y-x+i) >=0 && (y-x+i) < queen.length && queen[i][y-x+i] == 'Q')
    			return false;
    		if((y+x-i) >=0 && (y+x-i) < queen.length && queen[i][y+x-i] == 'Q')
    			return false;
    	}
    	return true;
    }
}
