
public class occofanumber {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 4, 2, 3, 5, 3, 4, 5, 3, 4, 5 };
		System.out.println(leftmostocc(arr, 3));
	}

	public static int leftmostocc(int[] array, int n) {
		int left, right;
		left = -1;
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == n) {
				left = mid;
				high = mid - 1;
			}
			if (array[mid] > n) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}
		return left;

	}

	public static int rightmostocc(int[] array, int n) {
		int left, right;
		left = -1;
		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (array[mid] == n) {
				left = mid;
				high = mid - 1;
			}
			if (array[mid] > n) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

	}
}
