package org.supersense.leetcode.problems.p134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int step = 0;
        int length = gas.length;
        while(step < length){
        	int ccost = 0;
        	int i;
        	for(i = 0; i < length; i ++){
        		int idx = (i + step)%length;
        		ccost += gas[idx];
        		ccost -= cost[idx];
        		if(ccost < 0){
        			break;
        		}
        	}
        	if(i == length){
        		return step;
        	}
        	step += (i + 1);
        }
        return -1;
    }
}
