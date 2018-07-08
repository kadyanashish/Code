package lecture11;

public class isarraysortedrecursively {

	public static void main(String[] args) {
		System.out.println(checksorted(new int[] { 1, 2, 3, 4, 5, 6 }));
	}

	public static boolean checksorted(int[] array) {
		if (array.length == 1) {
			return true;
		}
		if (array[0] > array[1]) {
			return false;
		} else {
			int[] smallarr = new int[array.length - 1];
			for (int i = 0; i < array.length - 1; i++) {
				smallarr[i] = array[i + 1];
			}
			boolean checksorted = checksorted(smallarr);

			return checksorted;
		}
	}
}
