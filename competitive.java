import java.util.Scanner;

public class competitive {
	
	static boolean[][] check=null; 
	static boolean[][] hills=null; 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		for (int i = 0; i < T; i++) {
			int m = scn.nextInt();
			int n = scn.nextInt();
			int[][] arr = new int[m][n];
			for (int j = 0; j < m; j++) {
				for (int l = 0; l < n; l++) {
					arr[j][l] = scn.nextInt();
				}
			}
			
		
			
			System.out.println(answer(arr));
		}
	

	}

	public static int answer(int[][] array){
		check=new boolean[array.length][array[0].length];
		hills=new boolean[array.length][array[0].length];
		

		int res = 0;

		

		
		int row = array.length;
		int col = array[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ((check[i][j] == false)) {
					hills[i][j]=true;
					skiing(array, check, i, j, i, j);

				}
			}

		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if ((check[i][j] == false)) {
					res++;

				}
			}

		}
		
		
		return res;
		
		
		
		
	}

	public static void skiing(int[][] array, boolean[][] check, int i, int j, int starti, int startj) {

		if ((checkfor(i, j + 1, check)) && (array[i][j + 1] <= array[i][j]) && !(i == starti && (j + 1) == startj)) {

			check[i][j + 1] = true;
			skiing(array, check, i, j + 1, starti, startj);
		}
		if (checkfor(i + 1, j, check) && array[i + 1][j] <= array[i][j] && !(i + 1 == starti && j == startj)) {

			check[i + 1][j] = true;
			skiing(array, check, i + 1, j, starti, startj);
		}
		if (checkfor(i, j - 1, check) && array[i][j - 1] <= array[i][j] && !(i == starti && j - 1 == startj)) {

			check[i][j - 1] = true;
			skiing(array, check, i, j - 1, starti, startj);
		}
		if (checkfor(i - 1, j, check) && array[i - 1][j] <= array[i][j] && !(i - 1 == starti && j == startj)) {

			check[i - 1][j] = true;
			skiing(array, check, i - 1, j, starti, startj);
		}

	}

	public static  boolean checkfor(int i, int j, boolean[][] check) {
		int row = check.length;
		int col = check[0].length;

		if (i < row && i >= 0 && j < col && j >= 0 && check[i][j] == false) {
			return true;
		}

		return false;
	}
}
