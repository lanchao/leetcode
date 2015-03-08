package org.supersense.leetcode.problems.p155;

public class MinStack {
	
	private int[] s;
	private int[] min;
	private int topIdx = -1;
	
	public MinStack() {
		s = new int[1024];
		min = new int[1024];
	}
	
    public void push(int x) {
       if(topIdx == s.length -1){
    	   adjS();
       }
       topIdx++;
       s[topIdx] = x;
       if(topIdx == 0){
    	   min[topIdx] = x;
       }else if(x < min[topIdx-1]){
    	   min[topIdx] = x;
       }else{
    	   min[topIdx] = min[topIdx-1];
       }
    }

    public void pop() {
        topIdx--;
    }

    public int top() {
        return s[topIdx];
    }

    public int getMin() {
        return min[topIdx];
    }
    
    private void adjS() {
    	int size = s.length * 2;
    	int[] news = new int[size];
    	int[] newmin = new int[size];
    	System.arraycopy(s, 0, news, 0, s.length);
    	System.arraycopy(min, 0, newmin, 0, min.length);
    	s = news;
    	min = newmin;
    }
}
