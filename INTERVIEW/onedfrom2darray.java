//this can be done inrow major form or column majorr form

package INTERVIEW;

import lecture6.arrayops;

public class onedfrom2darray {

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

		int[] res = twodfrom1d(array);
		arrayops.display(res);
	}

	public static int[] twodfrom1d(int[][] array) {
		int[] rv = new int[array.length * array[0].length];

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {

				int index = j + (i * array[i].length);
				rv[index] = array[i][j];

			}
		}

		return rv;
	}
}
