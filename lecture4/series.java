package lecture4;

import java.util.Scanner;

public class series {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N1 = scn.nextInt();
		int N2 = scn.nextInt();

		printSeries(N1, N2);
	}

	public static void printSeries(int N1, int N2) {
		if (N1 == 0) {
			return;
		}
		int n2 = N2 + 1;
		System.out.println(n2);
		for (int i = 0; i < N1-1; i++) {
			n2 = n2 + 6;
			System.out.println(n2);
			i++;
			if (i == N1-1)
				break;
			n2 += 3;
			i++;
			System.out.println(n2);
			if (i == N1-1)
				break;

			n2 += 3;
			System.out.println(n2);
		}
	}
}
