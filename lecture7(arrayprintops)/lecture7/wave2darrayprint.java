package lecture7;

import java.lang.reflect.Array;
import java.util.Scanner;

public class wave2darrayprint {

	public static void main(String[] args) {
		int[][] array = takeinput();
		display(array);
		int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 } };
		System.out.println();
		System.out.println("****************************************");
		display(arr);
		System.out.println("Printing wave output columnwise");
		waveprintcolumn(arr);
		System.out.println();
		System.out.println("****************************************");
		System.out.println("Printing wave output rowwise");
		waveprintrow(arr);
		System.out.println();
		System.out.println("****************************************");
		System.out.println("printing spiralprint anticlockwise ");
		spiralprintanticlockwise(arr);
		System.out.println();
		System.out.println("****************************************");
		System.out.println("printing spiralprint clockwise ");
		spiralprintclockwise(arr);

	}

	public static void waveprintcolumn(int[][] array) {

		for (int col = 0; col < array[0].length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < array.length; row++) {
					System.out.print(array[row][col] + " ");
				}
			} else {
				for (int row = array.length - 1; row >= 0; row--) {
					System.out.print(array[row][col] + " ");
				}
			}
		}

	}

	public static void waveprintrow(int[][] array) {
		for (int col = 0; col < array.length; col++) {
			if (col % 2 == 0) {
				for (int row = 0; row < array[0].length; row++) {
					System.out.print(array[col][row] + " ");
				}
			} else {
				for (int row = array[0].length - 1; row >= 0; row--) {
					System.out.print(array[col][row] + " ");
				}
			}
		}
	}

	public static int[][] takeinput() {
		int[][] retval = null;
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int rows = scn.nextInt();
		retval = new int[rows][];
		for (int row = 0; row < retval.length; row++) {
			System.out.println("Enter the number of columns for " + row + "th row");
			int cols = scn.nextInt();
			retval[row] = new int[cols];
			for (int i = 0; i < retval[row].length; i++) {
				System.out.println("Enter the value for cell " + row + "," + i);
				retval[row][i] = scn.nextInt();
			}

		}
		return retval;
	}

	public static void display(int[][] array) {
		if (array == null) {
			System.out.println("no rows, no colums");
		} else {
			System.out.println("Rows=" + array.length);
			for (int row = 0; row < array.length; row++) {
				if (array[row] == null || array[row].length == 0) {
					System.out.println("Blank row");
				} else {
					for (int col = 0; col < array[row].length; col++) {
						System.out.print(array[row][col] + "\t");
					}
					System.out.println();
				}
			}
		}
	}

	public static void spiralprintanticlockwise(int[][] array) {
		int mincol = 0, minrow = 0, maxcol = array[0].length - 1, maxrow = array.length - 1;
		int counter = array[0].length * array.length;
		while (counter > 0) {
			for (int i = minrow; i <= maxrow && counter > 0; i++) {
				System.out.print(array[i][mincol] + " ");
				counter--;
			}
			mincol++;

			for (int i = mincol; i <= maxcol && counter > 0; i++) {
				System.out.print(array[maxrow][i] + " ");
				counter--;
			}
			maxrow--;

			for (int i = maxrow; i >= 0 && counter > 0; i--) {
				System.out.print(array[i][maxcol] + " ");
				counter--;
			}
			maxcol--;

			for (int i = maxcol; i >= mincol && counter > 0; i--) {
				System.out.print(array[minrow][i] + " ");
				counter--;
			}
			minrow++;
			;

		}
	}

	public static void spiralprintclockwise(int[][] array) {
		int mincol = 0, minrow = 0, maxcol = array[0].length - 1, maxrow = array.length - 1;
		int counter = array[0].length * array.length;
		while (counter > 0) {
			for (int i = mincol; i <= maxcol && counter > 0; i++) {
				System.out.print(array[minrow][i] + " ");
				counter--;
			}
			minrow++;

			for (int i = minrow; i <= maxrow && counter > 0; i++) {
				System.out.print(array[i][maxcol] + " ");
				counter--;
			}
			maxcol--;

			for (int i = maxcol; i >= mincol && counter > 0; i--) {
				System.out.print(array[maxrow][i] + " ");
				counter--;
			}
			maxrow--;

			for (int i = maxrow; i >= minrow && counter > 0; i--) {
				System.out.print(array[i][mincol] + " ");
				counter--;
			}
			mincol++;
			;

		}
	}
}