package problems.p131;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	private List<List<String>> result = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        result.clear();
        dfs(s, new ArrayList<String>());
        return result;
    }
    
    private void dfs(String s, List<String> ss){
    	if(s.length() == 0){
    		result.add(ss);
    		return;
    	}
    	for(int i = 1; i <= s.length();i++){
    		String sub = s.substring(0, i);
    		if(isPalindrome(sub)){
    			List<String> nss = new ArrayList<String>();
    			nss.addAll(ss);
    			nss.add(sub);
    			dfs(s.substring(i), nss);
    		}else{
    			continue;
    		}
    	}
    }
    
    private boolean isPalindrome(String s){
    	int b = 0, e = s.length() - 1;
    	while(b < e){
    		if(s.charAt(b) != s.charAt(e)){
    			return false;
    		}
    		b++;
    		e--;
    	}
    	return true;
    }
}