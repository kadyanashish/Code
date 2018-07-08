package lec15;

public class subarraysummax {

	public static void main(String[] args) {
		maxsubarray(new int[] { 1, 3, 5 });
	}

	public static void maxsubarray(int[] array) {
		int max = 0, sum = 0, si = 0, m = 0, j, n = 0;
		int size = array.length;
		for (int i = 0; i < array.length; i++) {
			sum = 0;
			for (j = i; j < array.length; j++) {

				sum += array[j];

				if (sum > max) {
					max = sum;
					m = i;
					n = j;
				}

			}
		}
		System.out.println(max + " " + m + " " + n);
	}

}
