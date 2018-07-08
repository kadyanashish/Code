package INTERVIEW;

public class rotate {

	public static void main(String[] args) {
		System.out.println(rotate(3456, -1));
		System.out.println(rotate(3456, 8));
	}

	public static int rotate(int num, int n) {

		int rv = 0;
		int count = 0;
		int num1 = num;
		while (num != 0) {

			count++;
			num /= 10;
		}
		n = n % count;
		if (n < 0) {
			n = count + n;
		}

		// System.out.println(count);
		int tenpow = (int) Math.pow(10, n);
		// System.out.println(tenpow);

		int rem = num1 % tenpow;
		int quot = num1 / tenpow;
		/*
		 * System.out.println(rem); System.out.println(quot);
		 */

		rv = (int) (rem * Math.pow(10, count - n) + quot);

		return rv;
	}
}
