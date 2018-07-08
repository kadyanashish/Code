package codeschool;

public class q1 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 3, 3, 4, 5, 6, 7, 5 };
		System.out.println(rightmostocc(arr, 3));// returns index of rightmost 3
		System.out.println("total number = " + (rightmostocc(arr, 3) - leftmostocc(arr, 3) + 1));
	}

	public static int leftmostocc(int[] array, int n) {
		int left;
		left = -1;
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == n) {
				left = mid;
				high = mid - 1;
			} else if (array[mid] > n) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return left;

	}

	public static int rightmostocc(int[] array, int n) {
		int left, right;
		left = -1;
		int low = 0;
		int high = array.length - 1;
		int res = -1;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (array[mid] == n) {
				res = mid;
				low = mid + 1;
			}
			if (array[mid] > n) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return res;

	}
}
