package org.supersense.leetcode.problems.p36;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] h = new boolean[9][10];
        boolean[][] v = new boolean[9][10];
        boolean[][] q = new boolean[9][10];

        for(int i = 0; i < 9; i++){
        	for(int j = 0; j < 9; j ++){
        		char cdig = board[i][j];
        		if(cdig != '.'){
        			int dig = cdig - '0';
        			if(h[i][dig] || v[j][dig] || q[i/3*3+j/3][dig]){
        				return false;
        			}else{
        				h[i][dig] = true;
        				v[j][dig] = true;
        				q[i/3*3+j/3][dig] = true;
        			}
        		}
        	}
        }
        return true;
    }
}
