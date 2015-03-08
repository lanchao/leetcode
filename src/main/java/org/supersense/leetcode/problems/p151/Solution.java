package org.supersense.leetcode.problems.p151;

public class Solution {
    public String reverseWords(String s) {
        String[] ss = s.trim().split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i = ss.length -1; i>0; i--){
        	sb.append(ss[i]);
        	sb.append(" ");
        }
        if(ss.length !=0){
            sb.append(ss[0]);
        }
        return sb.toString();
    }
}
