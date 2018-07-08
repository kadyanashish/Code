package INTERVIEW;

import lecture6.arrayops;

public class SUBMATRIXMAXSUM {

	public static void main(String[] args) {

		int[][] array = { { 1, 2, -3 }, { 3, 200, 1 }, { -1, -3, 10 } };
		print2darray(array);

		System.out.println(submatmax(array, 2));
		// print2darray(array);
	}

	public static int submatmax(int[][] arr, int size) {// RETURN THE MAX SUM OF
														// A 2D ARRAY OF THE
														// GIVEN SIZE FROM THE
														// GIVEN MATRIX OF SIZE
														// n*n
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int l = 0; l < arr.length - size + 1; l++) {
			for (int k = 0; k < arr.length - size + 1; k++) {
				sum = 0;
				for (int i = l; i < l + size; i++) {
					for (int j = k; j < k + size; j++) {
						System.out.println(arr[i][j]);
						sum += arr[i][j];

					}

				}
				System.out.println("sum  " + sum);
				if (sum > max) {
					max = sum;
				}
			}
		}
		return max;
	}

	public static void print2darray(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
