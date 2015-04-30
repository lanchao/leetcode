package org.supersense.leetcode.problems.p52;

import java.util.List;

public class Solution {
	private int count = 0;
    public int totalNQueens(int n) {
    	if(n <= 0)
    		return 0;
        char[][] queen = new char[n][n];
        for(int i = 0; i < n; i++){
        	for(int j = 0; j < n; j++){
        		queen[i][j] = '.';
        	}
        }
        solve(queen, 0);
        return count;
    }
    
    private void solve(char[][] queen, int level) {
    	if(level >= queen.length){
			count++;
			return;
    	}
    	for(int i = 0; i < queen.length; i++){
    		if(isValid(queen, level, i)){
    			queen[level][i] = 'Q';
    			solve(queen, level + 1);
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
