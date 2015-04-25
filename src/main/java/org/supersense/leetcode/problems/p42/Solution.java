package org.supersense.leetcode.problems.p42;

public class Solution {
	public int trap(int[] height) {
        int left = 0, right = height.length - 1, preheight = 0, area = 0;
        while(left < right){
        	int h = height[left] < height[right] ? height[left] : height[right];
        		area += (h - preheight) * (right - left - 1);
        		preheight = h;
        	if(height[left] < height[right]){
        		int t = left+1;
        		while(t < right && height[t] <= preheight){
        			area -= height[t];
        			t++;
        		}
        		if(t < right){
        			area -= preheight;
        		}
        		left = t;
        	}else{
        		int t = right - 1;
        		while(t > left && height[t] <= preheight){
        			area -= height[t];
        			t--;
        		}
        		if(t > left){
        			area -= preheight;
        		}
        		right = t;
        	}
        }
        return area;
    }

 /*   public int trap(int[] height) {
        int left = 0, right = height.length - 1, preheight = 0, area = 0;
        while(left < right){
        	int h = height[left] < height[right] ? height[left] : height[right];
        	if(preheight < h){
        		area -= preheight;
        		area += (h - preheight) * (right - left - 1);
        		preheight = h;
        	}else{
        		area -= h;
        	}
        	if(height[left] < height[right]){
        		left++;
        	}else{
        		right--;
        	}
        }
        return area;
    }*/
}
