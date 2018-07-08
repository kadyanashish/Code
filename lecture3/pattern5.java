package lecture3;

import java.util.Scanner;

public class pattern5 {

	public static void main(String[] args) {
		System.out.println("Enter no. of rows");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = n;
		int middle = n / 2 + 1;
		for (int i = 0; i < middle; i++) {
			int space = middle - i - 1;
			for (int c = 0; c < space + 1; c++) {
				System.out.print("*\t");
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				System.out.print("\t");
			}
			for (int c = 0; c < space + 1; c++) {
				System.out.print("*\t");
			}
			System.out.println();
		}
		int k = n - middle;
		for (int m = 0; m < k; m++) {
			int space = m + 1;
			for (int a = 0; a < space + 1; a++) {
				System.out.print("*\t");
			}
			for (int b = 0; b < (k - m) * 2 - 1; b++) {
				System.out.print("\t");
			}
			for (int a = 0; a < space + 1; a++) {
				System.out.print("*\t");
			}
			System.out.println();
		}
	}

}
