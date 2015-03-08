package org.supersense.leetcode.problems.p174;

public class Solution {

    public int calculateMinimumHP(int[][] dungeon) {
       int[][] hp = new int[dungeon.length+1][dungeon[0].length+1];
       for(int i = 0; i < dungeon[0].length+1; i++){
    	   hp[dungeon.length][i] = Integer.MAX_VALUE;
       }
       for(int i = 0 ; i < dungeon.length ; i++) {
    	   hp[i][dungeon[0].length] = Integer.MAX_VALUE;
       }
       
       hp[dungeon.length-1][dungeon[0].length] = 1;
       hp[dungeon.length][dungeon[0].length-1] = 1;
       
       for(int i = dungeon.length -1; i>=0; i--){
    	   for(int j = dungeon[0].length -1; j >=0; j--){
    		   int need = Math.min(hp[i+1][j], hp[i][j+1]) - dungeon[i][j];
    		   hp[i][j] = need>0?need:1;
    	   }
       }

       return hp[0][0];
    }
}
