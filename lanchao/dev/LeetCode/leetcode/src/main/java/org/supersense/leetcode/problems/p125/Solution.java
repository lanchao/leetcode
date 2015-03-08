package problems.p125;

public class Solution {
	public boolean isPalindrome(String s) {
		
		String ls = s.toLowerCase();
		String ts = filter(ls);
		String rts = reverseString(ts);
		return ts.equals(rts);
        
    }
	
	private String filter(String s){
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i< s.length(); i++){
			if(Character.isLetterOrDigit(s.charAt(i))){
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	
	private String reverseString(String s){
		StringBuffer sb = new StringBuffer();
		for(int i = s.length()-1; i >=0; i--){
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
