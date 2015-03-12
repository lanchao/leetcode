package org.supersense.leetcode.problems.p11;

public class Solution {
    public int maxArea(int[] height) {
        return basicSolution(height);
    }
    
    private int basicSolution(int[] height) {
    	int max = 0;
    	int l = 0, r = height.length - 1;
    	while(l < r){
    		max = Math.max(max, (r - l)*Math.min(height[l], height[r]));
    		if(height[l]<height[r]){
    			int lh = height[l];
    			while(l < r && height[l] <= lh){
    				l++;
    			}
    		}else{
    			int rh = height[r];
    			while(l < r && height[r] <= rh){
    				r--;
    			}
    		}
    	}
    	return max;
    }
}
