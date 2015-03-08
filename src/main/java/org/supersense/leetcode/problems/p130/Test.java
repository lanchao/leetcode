package problems.p130;

public class Test {

	public static void main(String[] args) {
		Solution s = new Solution();
		char[][] c = {{'X','X','X'},{'X','O','X'},{'X','X','X'}};
		s.solve(c);
		for(int i = 0; i< c.length ;i++){
			for(int j = 0; j<c[0].length ;j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}

}
