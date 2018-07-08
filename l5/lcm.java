package l5;

import java.util.Scanner;

public class lcm {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N1 = scn.nextInt();
		int N2 = scn.nextInt();

		System.out.println(gcd(N1, N2));
	}

	public static int gcd(int n1, int n2) {
		int retVal = 0;
		if (n1 > n2) {
			int temp = n1;
			n2 = n1;
			n1 = temp;
		}
		int gcdis = 0;
		for (int i = 1; i < n2; i++) {
			if (n1 % i == 0 && n2 % i == 0) {
				gcdis = i;
			}

		}

		return gcdis;
	}

	public static int lcm(int n, int m) {
		int retval = 0;
		int gcd = gcd(n, m);
		retval = n * m / gcd;
		return retval;
	}
}