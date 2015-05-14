package org.supersense.leetcode.problems.p200;

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
        	return 0;
        }
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0; i < grid.length; i++){
        	for(int j = 0; j < grid[0].length; j++){
        		if(grid[i][j] == '1' && !visited[i][j]){
        			count++;
        			dfs(grid, visited, i, j);
        		}
        	}
        }
        return count;
    }
    void dfs(char[][] grid, boolean[][] visited, int x, int y){
    	if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
    		return;
    	}
    	if(grid[x][y] == '1' && !visited[x][y]){
    		visited[x][y] = true;
    		dfs(grid, visited, x-1, y);
    		dfs(grid, visited, x , y-1);
    		dfs(grid, visited, x+1, y);
    		dfs(grid, visited, x , y+1);
    	}
    }
}
