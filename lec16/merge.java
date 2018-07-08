package lec16;

import lecture6.arrayops;

public class merge {

	public static void main(String[] args) {

		int[] one = { 1, 4, 7, 15, 19 };
		int[] two = { 3, 6, 9, 18, 20, 29 };
		System.out.println("performing merge operation");
		int[] three = merge(one, two);
		arrayops.display(three);

		int[] arr = { 15, 2, 6, 1, 18 };
		System.out.print("Performing Mergesort on:: ");
		arrayops.display(arr);

		arr = mergesort(arr, 0, arr.length - 1);
		arrayops.display(arr);

	}

	public static int[] merge(int[] arr1, int[] arr2) {

		int k = 0, i = 0, j = 0;
		int[] rv = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				rv[k] = arr1[i];
				i++;
				k++;
			} else {
				rv[k] = arr2[j];
				j++;
				k++;
			}
		}
		while (i < arr1.length) {
			rv[k] = arr1[i];
			i++;
			k++;
		}
		while (j < arr2.length) {
			rv[k] = arr2[j];
			j++;
			k++;
		}

		return rv;
	}

	public static int[] mergesort(int[] array, int low, int high) {
		if (low == high) {
			int[] base = new int[1];
			base[0] = array[low];
			return base;
		}

		int mid = (low + high) / 2;
		int[] fhalf = mergesort(array, low, mid);
		int[] shalf = mergesort(array, mid + 1, high);

		int[] complete = merge(fhalf, shalf);

		return complete;

	}
}