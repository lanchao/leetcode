package org.supersense.leetcode.problems.p50;

public class Solution {
    public double pow(double x, int n) {
        return n > 0 ? bitpower(x, n) : 1 / bitpower(x, -n);
    }
    
    
    double power(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1.0;
        double tmp = power(x, n / 2);
        return n % 2 == 0 ? tmp * tmp : tmp * tmp * x;
    }
    
    double bitpower(double x, int n){
    	double ret = 1;
    	while(n > 0){
    		if((n & 0x0001) != 0){
    			ret *= x;
    		}
    		x *= x;
    		n = n >> 1;
    	}
    	return ret;
    }
}
