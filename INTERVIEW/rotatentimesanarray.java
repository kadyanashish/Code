package INTERVIEW;

import lecture6.arrayops;

public class rotatentimesanarray {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int rv[] = rotatentimes(arr, 4);
		arrayops.display(rv);
	}

	public static int[] rotatentimes(int[] array, int n) {
		n = n % array.length;
		if (n < 0) {
			n = array.length + n;
		}
		int size = 0;
		int[] rv = new int[array.length];
		int first = n;
		for (int i = 0; i < rv.length; i++) {

			int index = (size + first) % array.length;

			rv[index] = array[i];
			size++;

		}

		return rv;

	}
}
