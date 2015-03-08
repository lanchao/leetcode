package problems.p139;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        for(int i = 0; i< s.length(); i++){
        	dp[i] = false;
        }
        dp[0] = true;
        for(int i = 0; i<= s.length(); i++){
        	for(int j = i-1; j>=0; j--){
        		if(dp[j]){
        			String sub = s.substring(j, i);
        			if(dict.contains(sub)){
        				dp[i] = true;
        				break;
        			}
        		}
        	}
        }
        return dp[s.length()];
    }
}
