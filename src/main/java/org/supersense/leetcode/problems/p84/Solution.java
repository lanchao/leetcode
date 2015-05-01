package org.supersense.leetcode.problems.p84;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
	public int largestRectangleArea(int[] height) {
		int[] hei = Arrays.copyOf(height, height.length + 1);
		hei[height.length] = 0;
		Stack<Integer> s = new Stack<Integer>();
		int max_area = 0;
		for (int i = 0; i < hei.length; i++) {
			while (!s.isEmpty() && hei[s.peek()] >= hei[i]) {
				int newheight = hei[s.pop()];
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
