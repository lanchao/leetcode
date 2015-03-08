package problems.p172;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(f(20));
		Solution s = new Solution();
		System.out.print(s.trailingZeroes(5));
	}
	
	public static long f(int n){
		long r = 1;
		for(int i = 2; i<= n; i++){
			r *= i;
		}
		
		return r;
	}

}
