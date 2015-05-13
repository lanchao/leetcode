package org.supersense.leetcode.problems.p189;

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k % nums.length == 0){
        	return;
        }
        int len = nums.length;
        k = k % len;
        if(len % k != 0 && len % (len - k)!= 0){
        	move(nums, k, 0);
        }else if(len % k == 0){
        	for(int i = 0; i < k; i++){
            	move(nums, k, i);
            }
        }else{
        	for(int i = 0; i < len - k; i++){
            	move(nums, k, i);
            }
        }
    }
    private void move(int[] nums, int k, int s){
    	int len = nums.length;
    	int idx = (s + k) % len;
        int pre = nums[idx];
        nums[idx] = nums[s];
        while(idx != s){
        	idx = (idx + k) % len;
        	int tmp = pre;
        	pre = nums[idx];
        	nums[idx] = tmp;
        }
    }
}