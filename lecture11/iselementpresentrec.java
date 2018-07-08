package lecture11;

public class iselementpresentrec {

	public static void main(String[] args) {
		// System.out.println(ispresent(new int[] { 1, 2, 3, 4, 5, 6 SF}, 90));
		// System.out.println(ispresentsmarterindex(new int[] { 1, 2, 3, 4, 5, 6
		// }, 6,0));
		System.out.println(ispresentsmarterlastindex(new int[] { 1, 3, 3, 4, 5, 6 }, 3, 0));
		int count = 0;
		int[] arr = ispresentallindex(new int[] { 1, 3, 3, 4, 3, 3, 5, 6 }, 3, 0, count);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static boolean ispresent(int[] array, int n) {
		if (array.length == 1) {
			return false;
		}
		if (array[0] == n) {
			return true;
		} else {
			int[] smallarr = new int[array.length - 1];
			for (int i = 0; i < array.length - 1; i++) {
				smallarr[i] = array[i + 1];
			}
			boolean checksorted = ispresent(smallarr, n);

			return checksorted;
		}
	}

	public static boolean ispresentsmarter(int[] array, int n, int si) {
		if (array.length == si) {
			return false;
		}
		if (array[si] == n) {
			return true;
		}
		boolean checksorted = ispresentsmarter(array, n, si + 1);

		return checksorted;
	}

	public static int ispresentsmarterindex(int[] array, int n, int si) {
		if (array.length == si) {
			return -1;
		}
		if (array[si] == n) {
			return si;
		}
		si = ispresentsmarterindex(array, n, si + 1);

		return si;
	}

	public static int ispresentsmarterlastindex(int[] array, int n, int si) {
		if (array.length == si) {
			return -1;
		}
		int found = ispresentsmarterlastindex(array, n, si + 1);
		if (found != -1) {
			return found;
		} else {
			if (array[si] == n) {
				return si;
			} else {
				return -1;
			}
		}
	}

	public static int[] ispresentallindex(int[] array, int n, int si, int count) {
		if (array.length == si) {
			int[] arr = new int[count];
			return arr;
		}
		if (n == array[si]) {
			count++;
		}
		int[] found = ispresentallindex(array, n, si + 1, count);
		if (n == array[si]) {
			found[--count] = si;
		}
		return found;
	}
}