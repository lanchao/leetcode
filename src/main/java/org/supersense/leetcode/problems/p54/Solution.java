package org.supersense.leetcode.problems.p54;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> ret = new LinkedList<Integer>();
    	if(matrix == null || matrix.length == 0){
    		return ret;
    	}
        int xlength = matrix[0].length;
        int ylength = matrix.length;
        int step = xlength * ylength;
        int xstep = 1, xidx = -1, ystep = 1, yidx = 0;
        boolean hmove = true;
        while(step > 0){
        	if(hmove){
        		ylength--;
        		for(int i = 0; i < xlength; i++){
        			xidx += xstep;
        			ret.add(matrix[yidx][xidx]);
        			step--;
        		}
        		xstep *= -1;
        		hmove = false;
        	}else{
        		xlength--;
        		for(int i = 0; i < ylength; i++){
        			yidx += ystep;
        			ret.add(matrix[yidx][xidx]);
        			step--;
        		}
        		ystep *= -1;
        		hmove = true;
        	}
        }
        return ret;
    }
}