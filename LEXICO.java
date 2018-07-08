
public class LEXICO {

	public static void main(String[] args) {
		lexico(100, 1);
	}

	public static void lexico(int end, int current) {
		if (current == end) {
			System.out.println(current);
			return;
		}
		if (current > end) {
			return;
		}
		System.out.println(current);
		for (int i = (current == 0 ? 1 : 0); i <= 9; i++) {
			lexico(end, 10 * current + i);
		}

	}

	public static void revlexico(int end, int current) {
		if (current == end) {
			System.out.println(current);
			return;
		}
		if (current > end) {
			return;
		}
		for (int i = 9; i >= (current == 0 ? 1 : 0); i--) {
			lexico(end, 10 * current + i);
		}
		System.out.println(current);

	}

	public static void printSG(int[] arr, int si, int sum1, int sum2, String osf1, String osf2) {
		if (si == arr.length) {
			if (sum1 == sum2) {
				System.out.println(osf1 + "," + osf2);
			}
			return;
		}

		printSG(arr, si + 1, sum1 + arr[si], sum2, osf1 + arr[si], osf2);
		printSG(arr, si + 1, sum1, sum2 + arr[si], osf1, osf2 + arr[si]);
	}

	public static void printBP(int end, int current, int[] ladders, String osf) {
		if (current == end) {
			System.out.println(osf + "END");
			return;
		}
		if (current > end) {
			return;

		}

		if (ladders[current] != 0) {
			printBP(end, ladders[current], ladders, osf + 'L');

		} else {
			for (int dice = 1; dice <= 6; dice++) {
				printBP(end, current + dice, ladders, osf + 'D' + dice);
			}
		}
	}

	public static boolean isValidPath(int end, int current, int[] SnL, int[] DV, int si) {
		if (current == end) {
			return true;
		}
		if (current > end) {
			return false;
		}

		if (si == DV.length) {
			return false;
		}
		boolean ans = false;
		if (SnL[current] != 0) {
			ans = isValidPath(end, SnL[current], SnL, DV, si);
		} else {
			ans = isValidPath(end, current + DV[si], SnL, DV, si + 1);

		}
		return ans;

	}
}
