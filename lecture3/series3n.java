package lecture3;

import java.util.Scanner;

public class series3n {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N1 = scn.nextInt();
		int N2 = scn.nextInt();

		printSeries(N1, N2);
	}

	public static void printSeries(int N1, int N2) {
		int count = 1;
		int i = 1;
		while (count <= N1) {
			if (((3 * i + 2) % N2) != 0) {
				System.out.println(3 * i + 2);
				count++;
				i++;
			}
			else
			i++;
		}
	}
}