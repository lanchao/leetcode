package org.supersense.leetcode.problems.p128;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
        	return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for(int i = 0; i < nums.length; i++){
        	if(!map.containsKey(nums[i])){
        		map.put(nums[i], 1);
        		int s = nums[i];
        		int e = nums[i];
        		if(map.containsKey(nums[i] + 1)){
        			e = nums[i] + map.get(nums[i] + 1);
        		}
        		if(map.containsKey(nums[i] - 1)){
        			s = nums[i] - map.get(nums[i] - 1);
        		}
        		map.put(s, e - s + 1);
        		map.put(e, e - s + 1);
        		if(e - s + 1 > max){
        			max = e - s + 1;
        		}
        	}
        }
        return max;
    }
}
