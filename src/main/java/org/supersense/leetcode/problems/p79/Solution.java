package org.supersense.leetcode.problems.p79;

public class Solution {
    public boolean exist(char[][] board, String word) {
    	boolean[][] read = new boolean[board.length][board[0].length];
    	char[] cs = word.toCharArray();
    	for(int i = 0; i < board.length; i++){
    		for(int j = 0; j < board[0].length; j++){
    			if(dfs(board, read, i, j, 0, cs)){
    				return true;
    			}
    		}
    	}
    	return false;
    }
    private boolean dfs(char[][] board, boolean read[][], int i, int j, int k, char[] word){
    	if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1){
    		return false;
    	}
    	if(k > word.length - 1){
    		return false;
    	}
    	if(k == word.length - 1 && board[i][j] == word[k] && read[i][j] == false){
    		return true;
    	}
    	if(board[i][j] == word[k] && read[i][j] == false){
    		read[i][j] = true;
    		boolean ret =  dfs(board, read, i + 1, j, k + 1, word) || dfs(board, read, i, j + 1, k + 1, word) || dfs(board, read, i - 1, j, k + 1, word) || dfs(board, read, i, j - 1, k + 1, word);
    		read[i][j] = false;
    		return ret;
    	}
    	return false;
    }
}
