package org.supersense.leetcode.problems.p15;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	
    public List<List<Integer>> fourSum(int[] num, int target) {
    	List<List<Integer>> ret = new LinkedList<List<Integer>>();
    	if(num == null || num.length < 4){
    		return ret;
    	}
    	Arrays.sort(num);
    	for(int i = 0; i < num.length -3; i++){
    		int a = num[i];
    		int t = target - num[i];
    		List<List<Integer>> lret = threeSum(num, i+1, t);
    		List<List<Integer>> nret = new LinkedList<List<Integer>>();
    		for(List<Integer> li : lret){
    			List<Integer> nli = new LinkedList<Integer>();
    			nli.add(a);
    			nli.addAll(li);
    			nret.add(nli);
    		}
    		if(!nret.isEmpty()){
    			ret.addAll(nret);
    		}
      		while(i+1<num.length && num[i+1] == num[i]){
    			i++;
    		}
    	}
    	return ret;
    }
	
    public List<List<Integer>> threeSum(int[] num, int begin, int target) {
    	List<List<Integer>> ret = new LinkedList<List<Integer>>();
    	for(int i = begin; i < num.length -2;i++){
    		int a = num[i];
    		int start = i+ 1;
    		int end = num.length -1;
    		int b, c;
    		while(start < end){
    			b = num[start];
    			c = num[end];
    			if(a + b + c == target){
    				ret.add(Arrays.asList(a,b,c));
    				while(start<end && num[start] == b){
    					start++;
    				}
    				while(start<end && num[end] == c){
    					end--;
    				}
    			}else if(a + b + c < target){
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
