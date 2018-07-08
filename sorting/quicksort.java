package sorting;

import lecture6.swaparrayelements;

public class quicksort {

	public static void main(String[] args) {
		int[] arr = { 5, 10, 4, 6, 4, 4, 33 };
		/* partition(arr, 0, arr.length - 1); */

		quicksort1(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int partition(int[] arr, int low, int high) {

		int l = low - 1;
		int pivot = arr[high];
		for (int i = low; i <= high - 1; i++) {// does not check for the last
												// index i.e pivot;(high rep the
												// last index not size)
			if (arr[i] <= pivot) {
				l++;
				swaparrayelements.swap(arr, l, i);

			}

		}
		swaparrayelements.swap(arr, l + 1, high);
		return l + 1;

	}

	public static void quicksort(int[] arr, int low, int high) {

		if (low < high) {

			int pi = partition(arr, low, high);

			quicksort(arr, low, pi - 1);
			quicksort(arr, pi + 1, high);

		}

	}

	public static int partition1(int[] array, int low, int high) {
		int pivot = array[high];
		int l = low - 1;

		for (int j = low; j < high; j++) {
			if (array[j] < pivot) {
				l = l + 1;
				swaparrayelements.swap(array, l, j);
			}

		}
		swaparrayelements.swap(array, l + 1, high);
		return l + 1;

	}

	public static void quicksort1(int[] array, int low, int high) {

		if (low < high) {
			int pivotingindex = partition1(array, low, high);
			quicksort(array, low, pivotingindex - 1);
			quicksort(array, pivotingindex + 1, high);

		}
	}

}
