package doubts;

import lecture6.arrayops;

public class demo1 {

	public static void main(String[] args) {

		// PrintDI(5);
		int[] arr = { 7, 2, 2, 5, 3, 2, 7, 2 };
		System.out.println(max(arr, 1));
		int[] rv = allindices(arr, 0, 2, 0);
		arrayops.display(rv);

	}

	public static void PrintDI(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		PrintDI(n - 1);
		System.out.println(n);

	}

	public static int max(int[] arr, int si) {
		if (si == arr.length - 1) {
			return arr[arr.length - 1];
		}

		int value = max(arr, si + 1);
		int max = arr[si];
		if (value > max) {
			return value;
		} else {
			return max;
		}

	}

	public static int[] allindices(int[] arr, int si, int data, int count) {
		if (si == arr.length) {
			int[] rv = new int[count];
			return rv;
		}

		if (arr[si] == data) {
			count++;
		}
	
		int[] rv = allindices(arr, si + 1, data, count);
		if (arr[si] == data) {
			rv[count - 1] = si;
		}

		return rv;

	}
}
