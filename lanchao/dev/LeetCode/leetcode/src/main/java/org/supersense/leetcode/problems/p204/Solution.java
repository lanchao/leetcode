package org.supersense.leetcode.problems.p204;

public class Solution {

	private int max = 1;
	private int[] prime = new int[10000000];

	// private boolean[] notprime = new boolean[10000000];
	/*
	 * public int countPrimes2(int n) { if(n == 0 || n == 1){ return 0; } if(max
	 * == 0){ init(1000000); max = 1000000; } if(n > max){ init(n); max = n; }
	 * int count = 0; for(int i = 2; i <= n; i++){ if(!notprime[i]){ count++; }
	 * } return count; }
	 * 
	 * private void init(int n){ for(int i = 2; i < Math.sqrt(n); i++){
	 * if(!notprime[i]){ int j = i * i; while(j <= n){ notprime[j] = true; j +=
	 * i; } } } }
	 */

	/*
	 * public int countPrimes1(int n) { if(n == 0 || n == 1){ return 0; } if(n
	 * == 2){ return 1; } if(n <= max + 1){ if((n & 1) == 1){ return prime[n];
	 * }else{ return prime[n-1]; }
	 * 
	 * } int count = prime[max]; int i = max + 2; for(i = max + 2; i <= n;
	 * i+=2){ if(isPrime(i)){ count++; prime[i] = count; } } max = i; return
	 * count; }
	 * 
	 * private boolean isPrime(int n){ for(int i = 2; i < Math.sqrt(n); i++){
	 * if(n % i == 0){ return false; } } return true; }
	 */
	public int countPrimes(int n) {
		if (n < 2) {
			return 0;
		}
		boolean[] notPrime = new boolean[n - 2];
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (!notPrime[i]) {
				for (int j = i; j <= (n - 1) / i; j++) {
					notPrime[i * j - 2] = true;
				}
			}
		}
		int count = 0;
		for (boolean b : notPrime) {
			if (!b) {
				count++;
			}
		}
		return count;
	}
}
