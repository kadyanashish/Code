package lecture4;

import java.util.Scanner;

public class gcd {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int N1 = scn.nextInt();
		int N2 = scn.nextInt();

		System.out.println(gcd1(N1, N2));
	}

	public static int gcd1(int n1, int n2) {
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
}
