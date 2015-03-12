package org.supersense.leetcode.problems.p15;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
    	List<List<Integer>> ret = new LinkedList<List<Integer>>();
    	if(num == null || num.length < 3){
    		return ret;
    	}
    	Arrays.sort(num);
    	for(int i = 0; i < num.length -2;i++){
    		int a = num[i];
    		int start = i+ 1;
    		int end = num.length -1;
    		int b, c;
    		while(start < end){
    			b = num[start];
    			c = num[end];
    			if(a + b + c == 0){
    				ret.add(Arrays.asList(a,b,c));
    				while(start<end && num[start] == b){
    					start++;
    				}
    				while(start<end && num[end] == c){
    					end--;
    				}
    			}else if(a + b + c < 0){
    				start++;
    			}else{
    				end--;
    			}
    		}
    		while(i+1<num.length && num[i+1] == num[i]){
    			i++;
    		}
    	}
    	return ret;
    }
}
