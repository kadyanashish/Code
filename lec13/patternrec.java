package lec13;

import lecture6.arrayops;

public class patternrec {

	public static void main(String[] args) {
		patternrec(5, 5);
		int[] array = { 1, 5, 2, 8, 2, 3, 2, 5 };
		selecsort(array, 0, 1);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}

	public static void patternrec(int row, int col) {
		if (row == 0) {
			return;
		}
		if (col == 0) {
			System.out.println();
			patternrec(row - 1, row - 1);
			return;
		}

		System.out.print("*\t");
		patternrec(row, col - 1);

	}

	public static int[] selecsort(int[] array, int si, int li) {
		if (si == array.length) {
			return array;
		}
		if (li == array.length) {
			selecsort(array, si + 1, si + 2);
			return array;
		}
		if (array[si] > array[li]) {
			int temp = array[li];
			array[li] = array[si];
			array[si] = temp;
		}
		int[] arr = selecsort(array, si, li + 1);
		return arr;
	}
}