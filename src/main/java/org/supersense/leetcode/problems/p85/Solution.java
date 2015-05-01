package org.supersense.leetcode.problems.p85;

import java.util.Stack;

public class Solution {
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0){
			return 0;
		}
        int[] height = new int[matrix[0].length+1];
        int max_area = 0;
        for(int i = 0; i < matrix.length; i++){
        	for(int j = 0; j < matrix[0].length; j++){
        		if(matrix[i][j] == '1')
        			height[j] = height[j]+1;
        		else
        			height[j] = 0;
        	}
        	int area = largestRectangleArea(height);
        	if(max_area < area)
        		max_area = area;
        }
        return max_area;
    }

	private int largestRectangleArea(int[] height) {
		Stack<Integer> s = new Stack<Integer>();
		int max_area = 0;
		for (int i = 0; i < height.length; i++) {
			while (!s.isEmpty() && height[s.peek()] >= height[i]) {
				int newheight = height[s.pop()];
				int width = (s.isEmpty()) ? i : (i - s.peek() - 1);
				int newarea = width * newheight;
				if (newarea > max_area)
					max_area = newarea;
			}
			s.push(i);
		}
		return max_area;
	}
}
